from datetime import datetime
import pytz
import requests

# 한국 시간대 설정
KST = pytz.timezone('Asia/Seoul')

# 날짜와 시간 포맷을 'YYYY-MM-DD HH:mm' 형식으로 변환
def get_kst_time(commit_time):
    # 커밋 시간을 한국 시간대로 변환
    utc_time = datetime.strptime(commit_time, "%Y-%m-%dT%H:%M:%SZ")
    kst_time = utc_time.replace(tzinfo=pytz.utc).astimezone(KST)
    return kst_time.strftime('%Y-%m-%d %H:%M')

# GitHub API 응답에서 파일 목록을 처리하는 코드
def get_data(user_repo):
    # GitHub API를 사용하여 파일 목록 가져오기
    url = f"https://api.github.com/repos/{user_repo}/git/trees/main?recursive=1"
    response = requests.get(url)
    response_data = [item for item in response.json()['tree'] if item['type'] == 'blob' and not item['path'].startswith('.')]

    sites = []
    difficulties = []
    problems = []
    commit_times = []

    # 파일 경로에서 사이트, 난이도, 문제번호/이름 추출
    for item in response_data:
        path_parts = item['path'].split('/')
        if len(path_parts) >= 3:
            site = path_parts[0]
            difficulty = path_parts[1]
            problem = path_parts[2]  # 문제 이름 전체(확장자 포함) 가져오기
            sites.append(site)
            difficulties.append(difficulty)
            problems.append(problem)

            # 각 파일의 마지막 커밋 시간 가져오기
            file_url = f"https://api.github.com/repos/{user_repo}/commits?path={item['path']}"
            commit_response = requests.get(file_url)
            commit_data = commit_response.json()
            if commit_data:
                commit_time = commit_data[0]['commit']['committer']['date']
                commit_times.append(get_kst_time(commit_time))
            else:
                commit_times.append(current_time)  # 커밋이 없으면 현재 시간 사용

    return sites, difficulties, problems, commit_times

# 업데이트된 README 내용 생성
def update_readme(repo, sites, difficulties, problems, commit_times, original_content):
    # "## 📑List📑" 섹션 찾기
    start_index = original_content.find("## 📑List📑")
    if start_index != -1:
        # "## 📑List📑" 이후 내용을 삭제
        end_index = original_content.find("\n", start_index + 1)
        original_content = original_content[:start_index] + original_content[end_index:]

    # 새로운 테이블 생성
    new_table = "## 📑List📑\n\n"
    new_table += "| 사이트 | 난이도 | 문제 | 풀이일 |\n"
    new_table += "| --- | --- | --- | --- |\n"

    # 문제에 대한 정보 테이블 생성
    for i in range(len(sites)):
        site = sites[i]
        difficulty = difficulties[i]
        problem = problems[i]
        commit_time = commit_times[i]
        new_table += f"| {site} | {difficulty} | {problem} | {commit_time} |\n"

    updated_content = original_content + new_table
    return updated_content

# 기존 README.md 내용 읽기
try:
    with open("README.md", "r") as file:
        original_content = file.read()
except FileNotFoundError:
    original_content = ""

user_repo = "JinHyung-dev/Algorithm"

# 데이터 가져오기
sites, difficulties, problems, commit_times = get_data(user_repo)

# 리드미 업데이트
updated_content = update_readme(user_repo, sites, difficulties, problems, commit_times, original_content)

# 업데이트된 내용을 리드미 파일에 저장
with open("README.md", "w") as file:
    file.write(updated_content)
