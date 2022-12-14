# TadeM
![로고](https://user-images.githubusercontent.com/108784880/197512666-f2a8c90d-5d90-4328-afba-d02556d6d1a5.png)
## 누구나 자신의 재능을 판매할 수 있는 재능거래소

### 프로젝트 소개 
- “나는 글을 잘 써”, “나는 그림을 잘 그려”, “나는 다른 사람들의 이야기를 잘 들어줘” 등등, 모든 사람들에게는 자신만의 재능이 있다고 생각합니다. 그럼 그 재능을 팔아보면 어떨까요?
- “글 첨삭을 받고 싶은데요.”, ”저희 가족모습을 그림으로 간직하고 싶어요.” 등등, 이러한 고민을 가진 사람들은 손쉽게 그 재능을 살 수 있다면 어떨까요?

### 프로젝트 기능 

<details>
<summary>접기/펼치기</summary>

## 공통
## 1. **회원가입과 로그인**

- 사용자는 회원가입을 할 수 있습니다.
    
    -  회원가입시, **‘이메일 ‘, ‘이름’, ‘비밀번호’, ‘전화번호’를 필수로 입력**해야 하며,
    
          **‘개인정보수집동의’, ‘개인정보 수집동의’ 부분을 필수로 체크**해야 합니다.
    
         ‘결제메일 전송 수신동의’는 선택 사항입니다.(구매자만)
    
    - 회원가입시 **이미 회원가입 된 이메일로** 회원가입을 시도하면 에러를 발생시킵니다.
    
- 구매자/판매자는 회원가입의 정보를 이용하여 로그인을 할 수 있습니다.

     - 로그인을 하기 위해서는 **등록된 이메일로 보내진 메일을 확인하여 계정을 활성화** 해야 합니다.

     - **계정 활성화가 되지 않았다면**, 로그인 시 에러가 발생합니다.

     - 로그인 시 **회원가입한적 없는 이메일을 이용하여 로그인을 시도**하면 에러가 발생합니다.

     - 로그인 시 **이메일과 비밀번호가 일치하지 않는다면** 에러가 발생합니다.

---

## 2. 회원탈퇴

- 사용자는 **‘마이페이지’ - ‘회원정보’ - ‘회원탈퇴’를 누르고 비밀번호를 입력**하면 회원탈퇴를 할 수 있습니다.

    - **회원탈퇴 처리된 회원이 다시 해당 정보로 로그인 시도시**, 에러가 발생합니다.

---

## 3. 구매자 / 판매자 거래진행

- 판매자가 올려놓은 상품을 구매자가 거래하게 되면 **1차적으로 해당 제품 가격에 맞는 금액이**

 **구매자 → 관리자에게 입금**됩니다. 이후 거래가 정상적으로 종료되고 구매자가 

‘마이페이지’ -  ‘거래내역 ’에서 ‘거래완료’를 클릭하면 **2차적으로 관리자 → 판매자에게** 

**금액이 입금**됩니다.(이 과정에서 일부 수수료가 발생합니다.)

- 거래내역에는 구매자에게는 ‘거래 신청중’ - ‘거래 진행중’ - ‘거래 완료’ 순으로

      판매자에게는 ‘거래 진행중’ - ‘거래 완료’ 순으로 진행순서가 표시됩니다.

---

## 4. 구매자 / 판매자 1 : 1대화

- 구매자가 상품페이지에 들어가, 우측 하단 **‘판매자와의 1 : 1채팅’ 버튼**을 누르면 구매자 / 판매자 채팅이 시작됩니다.

- 채팅 내용은 **‘마이페이지’ - ‘메세지함’** 을 확인하면 됩니다.
    
    # 구매자

## 1. 구매자 상품구매(의뢰)

- 구매자는 카테고리 - 해당 제품 페이지로 들어가 오른쪽 하단 ‘구매/의뢰’ 버튼을 눌러

      해당 상품을 구매할 수 있습니다.

    - 이미 구매한 상품은, **‘의뢰 진행중’ 상태에서 재신청 할 시** 에러가 발생합니다.

---

## 2. 구매자 의뢰게시판 글 작성 / 목록확인

- 구매자는 메인 페이지 ‘의뢰게시판’ - ‘글 작성’ 을 눌러 글을 쓸 수 있습니다.

      (의뢰를 신청 할 수 있습니다.)

    - 의뢰게시판 글 작성 시, **‘의뢰 제목’, ‘의뢰 내용’, ‘원하는 비용’, ‘원하는 기간’을 필수로 작성**해야        

      합니다.

- 구매자는 **‘마이페이지’ - ‘의뢰게시판 목록 확인’** 을 클릭해 올렸던 글을 확인할 수 있습니다.

---

## 3. 구매자 찜 하기 / 찜 목록 확인

- 구매자는 제품 페이지 오른쪽 하단 ‘찜하기’를 눌러 해당 제품을 찜 할 수 있습니다.

    - 한번 더 ‘찜하기’를 누르면 ‘찜하기’가 취소됩니다.

- 구매자는 **‘마이페이지’ - ‘찜 목록’ 에서** 자신이 찜한 제품의 목록들을 볼 수 있습니다.

---

## 4. 구매자 리뷰쓰기 / 내가 쓴 리뷰보기

- 구매자는 자신이 구매했던 제품에 한 해 리뷰를 작성할 수 있습니다.

   - **구매하지 않았던 제품에 ‘리뷰하기’를 클릭**하면, 에러가 발생합니다.

- 구매자는 **‘마이페이지’ - ‘내가 쓴 리뷰보기’ 에서** 자신이 썼던 리뷰들을 볼 수 있습니다.

# 판매자

## 1. 판매자 상품등록

- 판매자는 메인 페이지 우 상단 ‘상품등록’ 을 누르면 상품을 등록할 수 있습니다.

     - 상품 판매 시, **‘제품 이름’, ‘제품 설명’, ‘제품 가격’, ‘걸리는 기간’을 필수로 작성**해야 합니다.

---

## 2. 판매자 제품광고 신청

- 판매자는 자신의 제품을 일정 기간동안 메인 페이지에 ‘배너’ 형식으로 홍보 할 수 있습니다.

    - 자신의 제품 중 **‘1개’만** 가능합니다.

    - 홍보 신청 시, 일정 비용이 청구됩니다.

# 관리자

## 1. 관리자 기능

- 관리자는 **‘회원관리**’를 통해 회원의 ‘이메일’, ‘이름’, ‘비밀번호’, ‘전화번호’, ‘가입일’,

      ‘메일인증여부’, ‘회원상태’, ‘개인정보수집동의’, ‘ 개인정보 3자 제공동의’, ‘결제메일 전송 수신

      동의를 확인할 수 있습니다.

- 관리자는 **‘배너관리’**를 통해 판매자의 제품을 메인페이지에 홍보 해 줄 수 있습니다.

- 관리자는 **‘카테고리관리’**를 통해 카테고리를 관리할 수 있습니다.

- 관리자는 **‘공지사항관리’**를 통해 공지사항을 관리할 수 있습니다.

- 관리자는 **‘Q&A서비스 관리’**를 통해 Q&A서비스를 관리할 수 있습니다.
    
</details>
    
## 기술 스택
# BackEnd

1. SpringBoot
2. Java
3. Gradle

# FrontEnd
1. Html
2. JavaScript
3. Thymeleaf

# DataBase
1. JPA
2. MySQL

## 프로젝트ERD
![TadeM_ERD](https://user-images.githubusercontent.com/108784880/197512697-47abeaff-d5d1-445e-9460-85587e23a3af.png)


![test coverage](.github/badges/jacoco.svg)
