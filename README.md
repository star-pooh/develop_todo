## 일정 관리 앱(Develop Ver.)

------

### 프로젝트 소개

간단한 일정을 관리할 수 있는 프로젝트입니다.

View가 없기 때문에 Postman으로만 동작 확인이 가능하며, 상세 내용은 아래 `API 명세서`에 작성되어 있습니다.

------

### 기술 스택

![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
<br>
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

------

### API 명세서

<details>

| 기능       | Method | URL             | request     | response  | 
|:---------|:-------|:----------------|:------------|:----------|
| 일정 생성    | POST   | /api/todos      | RequestBody | 등록된 일정 정보 |
| 일정 전체 조회 | GET    | /api/todos      | -           | n건의 일정 정보 |
| 일정 1건 조회 | GET    | /api/todos/{id} | -           | 1건의 일정 정보 |
| 일정 수정    | PATCH  | /api/todos/{id} | RequestBody | 수정된 일정 정보 |
| 일정 삭제    | DELETE | /api/todos/{id} | -           | -         |

<summary>Lv1</summary>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "username": "사용자1",
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ❌     | String | 사용자 이름 |
| title    | ❌     | String | 일정 제목  |
| contents | ❌     | String | 일정 내용  |

    "username": "수정된 사용자1",
    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "수정된 사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>

</details>

<details>

| 기능        | Method | URL             | request     | response   | 
|:----------|:-------|:----------------|:------------|:-----------|
| 사용자 생성    | POST   | /api/users      | RequestBody | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users      | -           | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id} | -           | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id} | RequestBody | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id} | -           | -          |
|           |        |                 |             |            |
| 일정 생성     | POST   | /api/todos      | RequestBody | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos      | -           | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id} | -           | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id} | RequestBody | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id} | -           | -          |

<summary>Lv2</summary>

`POST` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ❌     | String | 사용자 이름 |
| email    | ❌     | String | 이메일    |

    "username": "수정된 사용자1",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ❌     | String | 일정 제목 |
| contents | ❌     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>

</details>

<details>

| 기능        | Method | URL             | request     | response   | 
|:----------|:-------|:----------------|:------------|:-----------|
| 사용자 생성    | POST   | /api/users      | RequestBody | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users      | -           | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id} | -           | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id} | RequestBody | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id} | -           | -          |
|           |        |                 |             |            |
| 일정 생성     | POST   | /api/todos      | RequestBody | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos      | -           | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id} | -           | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id} | RequestBody | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id} | -           | -          |

<summary>Lv3</summary>

`POST` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ❌     | String | 사용자 이름 |
| password | ❌     | String | 비밀번호   |
| email    | ❌     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ❌     | String | 일정 제목 |
| contents | ❌     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>

</details>

<details>

| 기능        | Method | URL               | request     | response   | 
|:----------|:-------|:------------------|:------------|:-----------|
| 로그인       | POST   | /api/login        | RequestBody | 로그인 정보     |
|           |        |                   |             |            |
| 사용자 생성    | POST   | /api/users/signup | RequestBody | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users        | -           | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id}   | -           | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id}   | RequestBody | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id}   | -           | -          |
|           |        |                   |             |            |
| 일정 생성     | POST   | /api/todos        | RequestBody | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos        | -           | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id}   | -           | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id}   | RequestBody | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id}   | -           | -          |

<summary>Lv4</summary>

`POST` /api/login
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;로그인
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명   |
|:---------|:------|:-------|:-----|
| password | ⭕     | String | 비밀번호 |
| email    | ⭕     | String | 이메일  |

    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseHeader

| 키                 | 값                                  | 
|:------------------|:-----------------------------------|
| Set-Cookie        | JSESSIONID=<세션값>; Path=/; HttpOnly |
| Content-Type      | application/json                   |
| Transfer-Encoding | chunked                            |
| Date              | Wed, 18 Dec 2024 13:17:58 GMT      |
| Keep-Alive        | timeout=60                         |
| Connection        | keep-alive                         |

</details>

<br>
<br>

`POST` /api/users/signup
&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ❌     | String | 사용자 이름 |
| password | ❌     | String | 비밀번호   |
| email    | ❌     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ❌     | String | 일정 제목 |
| contents | ❌     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>

</details>


<details>

| 기능        | Method | URL               | request     | response   | 
|:----------|:-------|:------------------|:------------|:-----------|
| 로그인       | POST   | /api/login        | RequestBody | 로그인 정보     |
|           |        |                   |             |            |
| 사용자 생성    | POST   | /api/users/signup | RequestBody | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users        | -           | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id}   | -           | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id}   | RequestBody | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id}   | -           | -          |
|           |        |                   |             |            |
| 일정 생성     | POST   | /api/todos        | RequestBody | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos        | -           | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id}   | -           | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id}   | RequestBody | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id}   | -           | -          |

<summary>Lv5</summary>

`POST` /api/login
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;로그인
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명   |
|:---------|:------|:-------|:-----|
| password | ⭕     | String | 비밀번호 |
| email    | ⭕     | String | 이메일  |

    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseHeader

| 키                 | 값                                  | 
|:------------------|:-----------------------------------|
| Set-Cookie        | JSESSIONID=<세션값>; Path=/; HttpOnly |
| Content-Type      | application/json                   |
| Transfer-Encoding | chunked                            |
| Date              | Wed, 18 Dec 2024 13:17:58 GMT      |
| Keep-Alive        | timeout=60                         |
| Connection        | keep-alive                         |

</details>

<br>
<br>

`POST` /api/users/signup
&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ⭕     | String | 일정 제목 |
| contents | ⭕     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
</details>

<details>

| 기능        | Method | URL               | request     | response   | 
|:----------|:-------|:------------------|:------------|:-----------|
| 로그인       | POST   | /api/login        | RequestBody | 로그인 정보     |
|           |        |                   |             |            |
| 사용자 생성    | POST   | /api/users/signup | RequestBody | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users        | -           | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id}   | -           | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id}   | RequestBody | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id}   | -           | -          |
|           |        |                   |             |            |
| 일정 생성     | POST   | /api/todos        | RequestBody | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos        | -           | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id}   | -           | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id}   | RequestBody | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id}   | -           | -          |
|           |        |                   |             |            |
| 댓글 생성     | POST   | /api/replies      | RequestBody | 등록된 댓글 정보  |
| 댓글 전체 조회  | GET    | /api/replies      | -           | n건의 댓글 정보  |
| 댓글 1건 조회  | GET    | /api/replies/{id} | -           | 1건의 댓글 정보  |
| 댓글 수정     | PATCH  | /api/replies/{id} | RequestBody | 수정된 댓글 정보  |
| 댓글 삭제     | DELETE | /api/replies/{id} | -           | -          |

<summary>Lv7</summary>

`POST` /api/login
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;로그인
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명   |
|:---------|:------|:-------|:-----|
| password | ⭕     | String | 비밀번호 |
| email    | ⭕     | String | 이메일  |

    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseHeader

| 키                 | 값                                  | 
|:------------------|:-----------------------------------|
| Set-Cookie        | JSESSIONID=<세션값>; Path=/; HttpOnly |
| Content-Type      | application/json                   |
| Transfer-Encoding | chunked                            |
| Date              | Wed, 18 Dec 2024 13:17:58 GMT      |
| Keep-Alive        | timeout=60                         |
| Connection        | keep-alive                         |

</details>

<br>
<br>

`POST` /api/users/signup
&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ⭕     | String | 일정 제목 |
| contents | ⭕     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ❌     | String | 일정 제목 |
| contents | ❌     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| contents | ⭕     | String | 댓글 내용  |
| userId   | ⭕     | Long   | 사용자 ID |
| todoId   | ⭕     | Long   | 일정 ID  |

    "contents": "댓글1",
    "userId": 1,
    "todoId": 1

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": [ 
            {
                "id": 1,
                "contents": "댓글1",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "contents": "댓글2",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| contents | ⭕     | String | 댓글 내용 |

    "contents": "수정된 댓글1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "수정된 댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
</details>


<details>

| 기능        | Method | URL               | request      | response   | 
|:----------|:-------|:------------------|:-------------|:-----------|
| 로그인       | POST   | /api/login        | RequestBody  | 로그인 정보     |
|           |        |                   |              |            |
| 사용자 생성    | POST   | /api/users/signup | RequestBody  | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users        | -            | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id}   | -            | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id}   | RequestBody  | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id}   | -            | -          |
|           |        |                   |              |            |
| 일정 생성     | POST   | /api/todos        | RequestBody  | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos        | RequestParam | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id}   | -            | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id}   | RequestBody  | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id}   | -            | -          |
|           |        |                   |              |            |
| 댓글 생성     | POST   | /api/replies      | RequestBody  | 등록된 댓글 정보  |
| 댓글 전체 조회  | GET    | /api/replies      | -            | n건의 댓글 정보  |
| 댓글 1건 조회  | GET    | /api/replies/{id} | -            | 1건의 댓글 정보  |
| 댓글 수정     | PATCH  | /api/replies/{id} | RequestBody  | 수정된 댓글 정보  |
| 댓글 삭제     | DELETE | /api/replies/{id} | -            | -          |

<summary>Lv8</summary>

`POST` /api/login
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;로그인
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명   |
|:---------|:------|:-------|:-----|
| password | ⭕     | String | 비밀번호 |
| email    | ⭕     | String | 이메일  |

    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseHeader

| 키                 | 값                                  | 
|:------------------|:-----------------------------------|
| Set-Cookie        | JSESSIONID=<세션값>; Path=/; HttpOnly |
| Content-Type      | application/json                   |
| Transfer-Encoding | chunked                            |
| Date              | Wed, 18 Dec 2024 13:17:58 GMT      |
| Keep-Alive        | timeout=60                         |
| Connection        | keep-alive                         |

</details>

<br>
<br>

`POST` /api/users/signup
&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

| 파라미터 이름  | 필수 여부 | 타입  | 기본값 | 설명     |
|:---------|:------|:----|:----|:-------|
| pageNum  | ❌     | int | 0   | 페이지 번호 |
| pageSize | ❌     | int | 10  | 페이지 크기 |

    GET /api/todos/?pageNum=1&pageSize=5

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },
            {
                "id": 3,
                "username": "사용자2",
                "title": "제목3",
                "contents": "내용3",
                "createdDate": "2024-12-18 19:30:33",
                "modifiedDate": "2024-12-18 19:30:33"
            },
            {
                "id": 4,
                "username": "사용자3",
                "title": "제목20",
                "contents": "내용20",
                "createdDate": "2024-12-18 19:39:33",
                "modifiedDate": "2024-12-18 19:39:33"
            },
            {
                "id": 5,
                "username": "사용자5",
                "title": "제목30",
                "contents": "내용30",
                "createdDate": "2024-12-18 19:49:33",
                "modifiedDate": "2024-12-18 19:49:33"
            }
        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ⭕     | String | 일정 제목 |
| contents | ⭕     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>
<br>
<br>

`POST` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| contents | ⭕     | String | 댓글 내용  |
| userId   | ⭕     | Long   | 사용자 ID |
| todoId   | ⭕     | Long   | 일정 ID  |

    "contents": "댓글1",
    "userId": 1,
    "todoId": 1

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`GET` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": [ 
            {
                "id": 1,
                "contents": "댓글1",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "contents": "댓글2",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

</details>

`PATCH` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| contents | ⭕     | String | 댓글 내용 |

    "contents": "수정된 댓글1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "수정된 댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

</details>

`DELETE` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

</details>

</details>

<details>

| 기능        | Method | URL               | request      | response   | 
|:----------|:-------|:------------------|:-------------|:-----------|
| 로그인       | POST   | /api/login        | RequestBody  | 로그인 정보     |
|           |        |                   |              |            |
| 사용자 생성    | POST   | /api/users/signup | RequestBody  | 등록된 사용자 정보 |
| 사용자 전체 조회 | GET    | /api/users        | -            | n건의 사용자 정보 |
| 사용자 1건 조회 | GET    | /api/users/{id}   | -            | 1건의 사용자 정보 |
| 사용자 정보 수정 | PATCH  | /api/users/{id}   | RequestBody  | 수정된 사용자 정보 |
| 사용자 삭제    | DELETE | /api/users/{id}   | -            | -          |
|           |        |                   |              |            |
| 일정 생성     | POST   | /api/todos        | RequestBody  | 등록된 일정 정보  |
| 일정 전체 조회  | GET    | /api/todos        | RequestParam | n건의 일정 정보  |
| 일정 1건 조회  | GET    | /api/todos/{id}   | -            | 1건의 일정 정보  |
| 일정 수정     | PATCH  | /api/todos/{id}   | RequestBody  | 수정된 일정 정보  |
| 일정 삭제     | DELETE | /api/todos/{id}   | -            | -          |
|           |        |                   |              |            |
| 댓글 생성     | POST   | /api/replies      | RequestBody  | 등록된 댓글 정보  |
| 댓글 전체 조회  | GET    | /api/replies      | -            | n건의 댓글 정보  |
| 댓글 1건 조회  | GET    | /api/replies/{id} | -            | 1건의 댓글 정보  |
| 댓글 수정     | PATCH  | /api/replies/{id} | RequestBody  | 수정된 댓글 정보  |
| 댓글 삭제     | DELETE | /api/replies/{id} | -            | -          |

<summary>Lv9 (리팩토링)</summary>

`POST` /api/login
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;로그인
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명   |
|:---------|:------|:-------|:-----|
| password | ⭕     | String | 비밀번호 |
| email    | ⭕     | String | 이메일  |

    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseHeader

| 키                 | 값                                  | 
|:------------------|:-----------------------------------|
| Set-Cookie        | JSESSIONID=<세션값>; Path=/; HttpOnly |
| Content-Type      | application/json                   |
| Transfer-Encoding | chunked                            |
| Date              | Wed, 18 Dec 2024 13:17:58 GMT      |
| Keep-Alive        | timeout=60                         |
| Connection        | keep-alive                         |

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| status  | HttpStatus 이름   |
| message | 에러 메시지          |
| code    | HttpStatus 코드 값 |

    {
        "status": "UNAUTHORIZED",
        "message": "로그인 해주세요.",
        "code": 401
    }

</details>

<br>
<br>

`POST` /api/users/signup
&nbsp;&nbsp;&nbsp;사용자 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "사용자1",
    "password": "1234",
    "email": "user1@test.com"

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 400,
        "message": "비밀번호는 4자 이상 10자 이내로 입력해주세요.",
        "status": "BAD_REQUEST"
    }

</details>

`GET` /api/users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 일정 ID  |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "email": "user1@test.com"
            },
            {
                "id": 2,
                "username": "사용자2",
                "email": "user2@test.com"
            },

                .....

        ]
    }

</details>

`GET` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름    | 타입     | 설명     |
|:---------|:-------|:-------|
| id       | Long   | 사용자 ID |
| username | String | 사용자 이름 |
| email    | String | 이메일    |

    {
        "userData": {
            "id": 1,
            "username": "사용자1",
            "email": "user1@test.com"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 사용자 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`PATCH` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자 정보
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| username | ⭕     | String | 사용자 이름 |
| password | ⭕     | String | 비밀번호   |
| email    | ⭕     | String | 이메일    |

    "username": "수정된 사용자1",
    "password": "1111",
    "email": "modifyUser1@test.com"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "userData": {
            "id": 1,
            "username": "수정된 사용자1",
            "email": "modifyUser1@test.com"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 사용자 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`DELETE` /api/users/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용자
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 사용자 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>
<br>
<br>

`POST` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| userId   | ⭕     | Long   | 사용자 ID |
| title    | ⭕     | String | 일정 제목  |
| contents | ⭕     | String | 일정 내용  |

    "userId": 1,
    "title": "제목1",
    "contents": "내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 400,
        "message": "사용자 ID는 필수 입력 값입니다.",
        "status": "BAD_REQUEST"
    }

</details>

`GET` /api/todos
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

| 파라미터 이름  | 필수 여부 | 타입  | 기본값 | 설명     |
|:---------|:------|:----|:----|:-------|
| pageNum  | ❌     | int | 0   | 페이지 번호 |
| pageSize | ❌     | int | 10  | 페이지 크기 |

    GET /api/todos/?pageNum=1&pageSize=5

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": [ 
            {
                "id": 1,
                "username": "사용자1",
                "title": "제목1",
                "contents": "내용1",
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "username": "사용자1",
                "title": "제목2",
                "contents": "내용2",
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },
            {
                "id": 3,
                "username": "사용자2",
                "title": "제목3",
                "contents": "내용3",
                "createdDate": "2024-12-18 19:30:33",
                "modifiedDate": "2024-12-18 19:30:33"
            },
            {
                "id": 4,
                "username": "사용자3",
                "title": "제목20",
                "contents": "내용20",
                "createdDate": "2024-12-18 19:39:33",
                "modifiedDate": "2024-12-18 19:39:33"
            },
            {
                "id": 5,
                "username": "사용자5",
                "title": "제목30",
                "contents": "내용30",
                "createdDate": "2024-12-18 19:49:33",
                "modifiedDate": "2024-12-18 19:49:33"
            }
        ]
    }

</details>

`GET` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "제목1",
            "contents": "내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 일정 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`PATCH` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| title    | ⭕     | String | 일정 제목 |
| contents | ⭕     | String | 일정 내용 |

    "title": "수정된 제목1",
    "contents": "수정된 내용1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 일정 ID  |
| username     | String | 사용자 이름 |
| title        | String | 일정 제목  |
| contents     | String | 일정 내용  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "todoData": {
            "id": 1,
            "username": "사용자1",
            "title": "수정된 제목1",
            "contents": "수정된 내용1",
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 일정 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`DELETE` /api/todos/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일정
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 일정 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>
<br>
<br>

`POST` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 생성
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명     |
|:---------|:------|:-------|:-------|
| contents | ⭕     | String | 댓글 내용  |
| userId   | ⭕     | Long   | 사용자 ID |
| todoId   | ⭕     | Long   | 일정 ID  |

    "contents": "댓글1",
    "userId": 1,
    "todoId": 1

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 400,
        "message": "내용은 필수 입력 값입니다.",
        "status": "BAD_REQUEST"
    }

</details>

`GET` /api/replies
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
전체 조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": [ 
            {
                "id": 1,
                "contents": "댓글1",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:03",
                "modifiedDate": "2024-12-18 19:29:03"
            },
            {
                "id": 2,
                "contents": "댓글2",
                "userId": 1,
                "todoId": 1,
                "createdDate": "2024-12-18 19:29:33",
                "modifiedDate": "2024-12-18 19:29:33"
            },

                .....

        ]
    }

</details>

`GET` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 1건
조회
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:29:03"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 댓글 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`PATCH` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
수정
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

| 필드 이름    | 필수 여부 | 타입     | 설명    |
|:---------|:------|:-------|:------|
| contents | ⭕     | String | 댓글 내용 |

    "contents": "수정된 댓글1"

## Response

### ResponseBody

| 필드 이름        | 타입     | 설명     |
|:-------------|:-------|:-------|
| id           | Long   | 댓글 ID  |
| contents     | String | 댓글 내용  |
| userId       | Long   | 사용자 ID |
| todoId       | Long   | 일정 ID  |
| createdDate  | String | 일정 작성일 |
| modifiedDate | String | 일정 수정일 |

    {
        "replyData": {
            "id": 1,
            "contents": "수정된 댓글1",
            "userId": 1,
            "todoId": 1,
            "createdDate": "2024-12-18 19:29:03",
            "modifiedDate": "2024-12-18 19:45:13"
        }
    }

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 댓글 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

`DELETE` /api/replies/{id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글
삭제
<details>
<summary>상세 내용</summary>

## Request

### Headers

| 키            | 값                | 설명                |
|:-------------|:-----------------|:------------------|
| Content-Type | application/json | 요청 본문 형식 지정(JSON) |

### Query Parameters

    None

### RequestBody

    None

## Response

### ResponseBody

    None

### Error Response

| 필드 이름   | 설명              |
|:--------|:----------------|
| code    | HttpStatus 코드 값 |
| message | 에러 메시지          |
| status  | HttpStatus 이름   |

    {
        "code": 404,
        "message": "존재하지 않는 댓글 ID 입니다. ID : 1111",
        "status": "NOT_FOUND"
    }

</details>

</details>

------

### ERD

https://www.erdcloud.com/d/JsDjKnBC7AzMqP2vm

![image](https://github.com/user-attachments/assets/4897f9e6-a66c-4fa5-922c-d1fcf056d9be)

------

### 프로젝트 구조(Lv9 기준)

    📂config
    ┣ 📜PasswordEncoder.java
    ┗ 📜WebConfig.java
    📂controller
    ┣ 📜AuthController.java
    ┣ 📜ReplyController.java
    ┣ 📜TodoController.java
    ┗ 📜UserController.java
    📂dto
    ┣ 📂login
    ┃ ┗ 📜LoginRequestDto.java
    ┣ 📂reply
    ┃ ┣ 📜ReplyCreateRequestDto.java
    ┃ ┣ 📜ReplyResponseDto.java
    ┃ ┗ 📜ReplyUpdateRequestDto.java
    ┣ 📂todo
    ┃ ┣ 📜TodoCreateRequestDto.java
    ┃ ┣ 📜TodoPagingResponseDto.java
    ┃ ┣ 📜TodoResponseDto.java
    ┃ ┗ 📜TodoUpdateRequestDto.java
    ┗ 📂user
    ┃ ┣ 📜UserCreateRequestDto.java
    ┃ ┣ 📜UserResponseDto.java
    ┃ ┗ 📜UserUpdateRequestDto.java
    📂entity
    ┣ 📜BaseEntity.java
    ┣ 📜Reply.java
    ┣ 📜Todo.java
    ┗ 📜User.java
    📂exception
    ┣ 📜CustomRepositoryException.java
    ┣ 📜CustomValidationException.java
    ┣ 📜ErrorDetails.java
    ┗ 📜GlobalExceptionHandler.java
    📂filter
    ┗ 📜LoginFilter.java
    📂repository
    ┣ 📜ReplyRepository.java
    ┣ 📜TodoRepository.java
    ┗ 📜UserRepository.java
    📂service
    ┣ 📜ReplyService.java
    ┣ 📜TodoService.java
    ┗ 📜UserService.java
    📂util
    ┣ 📜ErrorResponse.java
    ┗ 📜Parse.java
    📜DevelopTodoApplication.java

------

### 만들면서 신경썼던 점

1. 각 파일에서 일관된 기능만 수행할 수 있도록 구현하려고 했습니다.
2. 요구 사항 가이드에 있는 내용을 최대한 구현하려고 했습니다.
3. 강의와 세션에서 실습한 내용을 따라하기만 하는 것이 아닌 흐름을 이해하고 구현하려고 했습니다.
4. Javadoc 및 주석을 빼먹지 않으려고 했습니다.
5. 예외 처리를 제네릭 클래스를 사용해서 코드 중복 사용을 줄이려고 했습니다.