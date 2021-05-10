DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE ORDER_SEQ;
DROP SEQUENCE ITEM_SEQ;
DROP SEQUENCE TAKEIT_SEQ;
DROP SEQUENCE REVIEW_SEQ;

DROP TABLE TAKEIT_DETAIL CASCADE CONSTRAINTS PURGE;
DROP TABLE TAKEIT CASCADE CONSTRAINTS PURGE;

DROP TABLE ORDER_DETAIL CASCADE CONSTRAINTS PURGE;
DROP TABLE ORDERS CASCADE CONSTRAINTS PURGE;
DROP TABLE SHIPPING CASCADE CONSTRAINTS PURGE;

DROP TABLE ITEM CASCADE CONSTRAINTS PURGE;
DROP TABLE ITEM_CATEGORY CASCADE CONSTRAINTS PURGE;
DROP TABLE PACKING CASCADE CONSTRAINTS PURGE;

DROP TABLE BOARD  CASCADE CONSTRAINTS PURGE;
DROP TABLE BOARD_CATEGORY  CASCADE CONSTRAINTS PURGE;

DROP TABLE REVIEW CASCADE CONSTRAINTS PURGE;

DROP TABLE SELLER  CASCADE CONSTRAINTS PURGE;
DROP TABLE MEMBER CASCADE CONSTRAINTS PURGE;
DROP TABLE MEMBER_LOC CASCADE CONSTRAINTS PURGE;
DROP TABLE SHOP_CATEGORY CASCADE CONSTRAINTS PURGE;
DROP TABLE SHOP_LOC CASCADE CONSTRAINTS PURGE;
DROP TABLE CART CASCADE CONSTRAINTS PURGE;
----------------------------------------------------------------
--�Խ��� ������
CREATE SEQUENCE BOARD_SEQ
START WITH 1
INCREMENT BY 1;

-- ��ǰ ������
CREATE SEQUENCE ITEM_SEQ
START WITH 1
INCREMENT BY 1;

--�ֹ�������
CREATE SEQUENCE ORDER_SEQ
START WITH 1
INCREMENT BY 1;

--�հŷ� ������
CREATE SEQUENCE TAKEIT_SEQ
START WITH 1
INCREMENT BY 1;

--�ı� ������
CREATE SEQUENCE REVIEW_SEQ
START WITH 1
INCREMENT BY 1;
----------------------------------------------------------------
-- ��������
CREATE TABLE SHOP_LOC (
	SHOP_LOC_CODE VARCHAR2(10) NOT NULL -- ���������ڵ�,
  ,	SHOP_LOC_NAME VARCHAR2(50) NOT NULL -- ���������̸�
  ,	SHOP_LOC_LAT VARCHAR2(20) NOT NULL  -- ����
  ,	SHOP_LOC_LNG VARCHAR2(20) NOT NULL -- �浵
  
  ,CONSTRAINT PK_SHOP_LOC PRIMARY KEY(SHOP_LOC_CODE)
);
-- ����ī�װ�
CREATE TABLE SHOP_CATEGORY (
	SHOP_CATEGORY_NO VARCHAR2(10) NOT NULL -- ī�װ���ȣ,
  ,	SHOP_CATEGORY VARCHAR2(20) NOT NULL -- ī�װ��̸�
  
  , CONSTRAINT PK_SHOP_CATEGORY PRIMARY KEY(SHOP_CATEGORY_NO)
);
-- ȸ������
CREATE TABLE MEMBER_LOC (
	MEMBER_LOC_NO VARCHAR2(10) NOT NULL -- ȸ��������ȣ,
  ,	SHOP_LOC_CODE VARCHAR2(10) NOT NULL -- ���������ڵ�,
  ,	MEMBER_LOC_NAME VARCHAR2(50) NOT NULL -- ȸ�������̸�
  
  , CONSTRAINT PK_MEMBER_LOC PRIMARY KEY(MEMBER_LOC_NO, SHOP_LOC_CODE)
  , CONSTRAINT FK_SHOP_LOC_TO_MEMB_LOC FOREIGN KEY (SHOP_LOC_CODE) REFERENCES SHOP_LOC(SHOP_LOC_CODE) ON DELETE CASCADE
);
-- �Ǹ���
CREATE TABLE SELLER (
	SELLER_ID varchar2(50) NOT NULL -- �Ǹ���ȸ�����̵�,
  ,	SELLER_PW VARCHAR2(50) NOT NULL -- ��й�ȣ,
  ,	NAME VARCHAR(30) NOT NULL -- �̸�,
  ,	MOBILE CHAR(13) NOT NULL -- �޴���,
  ,	EMAIL VARCHAR(100) NOT NULL -- �̸���,
  ,	ENTRY_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- ��������,
  ,	POSTNO CHAR(5) NOT NULL -- �����ȣ,
  ,	ADDRESS VARCHAR(255) NOT NULL -- ���θ��ּ�,
  ,	ADDRESS_DETAIL VARCHAR(255) NOT NULL -- ���ּ�,
  ,	GRADE CHAR(1) DEFAULT 'S' NULL -- ���,
  ,	SELLER_NO CHAR(12) UNIQUE NOT NULL -- ����ڵ�Ϲ�ȣ,
  ,	SHOP_MOBILE VARCHAR2(13) NOT NULL -- ��������ó,
  ,	SHOP_NAME VARCHAR2(50) NOT NULL -- ������,
  ,	CUST_SCORE NUMBER(3,1) DEFAULT 0.0 NOT NULL -- ������,
  ,	SHOP_KAKAO_ID VARCHAR2(50) NULL -- īī������̵�,
  ,	SHOP_IMG VARCHAR2(200) NULL -- �����̹���,
  ,	SHOP_CATEGORY_NO VARCHAR2(10) NOT NULL -- ī�װ���ȣ,
  ,	SHOP_LOC_CODE VARCHAR2(10) NOT NULL -- ���������ڵ�
  
  , CONSTRAINT PK_SELLER_MEMBER PRIMARY KEY(SELLER_ID)
  , CONSTRAINT FK_SHOP_CATE_TO_SEL_MEMB FOREIGN KEY(SHOP_CATEGORY_NO) REFERENCES SHOP_CATEGORY(SHOP_CATEGORY_NO) ON DELETE CASCADE
  , CONSTRAINT FK_SHOPLOC_TO_SELMEMB FOREIGN KEY(SHOP_LOC_CODE) REFERENCES SHOP_LOC(SHOP_LOC_CODE) ON DELETE CASCADE
);

-- �Ϲ�
CREATE TABLE MEMBER (
	MEMBER_ID varchar2(50) NOT NULL -- �Ϲ�ȸ�����̵�,
  ,	MEMBER_PW VARCHAR2(50) NOT NULL -- ��й�ȣ,
  ,	NAME VARCHAR(30) NOT NULL -- �̸�,
  ,	MOBILE CHAR(13) NOT NULL -- �޴���,
  ,	EMAIL VARCHAR(100) NOT NULL -- �̸���,
  ,	ENTRY_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- ��������,
  ,	POSTNO CHAR(5) NOT NULL -- �����ȣ,
  ,	ADDRESS VARCHAR(255) NOT NULL -- ���θ��ּ�,
  ,	ADDRESS_DETAIL VARCHAR(255) NOT NULL -- ���ּ�,
  ,	GRADE CHAR(1) DEFAULT 'G' NULL -- ���,
  ,	POINT NUMBER(7,0) DEFAULT 1000 NULL -- ������,
  ,	BIRTH CHAR(10) NULL -- ����,
  ,	MEMBER_LOC_NO VARCHAR2(10) NULL -- ȸ��������ȣ,
  ,	SHOP_LOC_CODE VARCHAR2(10) NULL -- ���������ڵ�
  
  , CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_ID)
  , CONSTRAINT FK_MEMB_LOC_TO_GEN_MEMB FOREIGN KEY(MEMBER_LOC_NO,SHOP_LOC_CODE) REFERENCES MEMBER_LOC(MEMBER_LOC_NO, SHOP_LOC_CODE) ON DELETE CASCADE
);
-------------------------------------------------------------------------------
-- ����
CREATE TABLE PACKING (
	PACK_TYPE_NO VARCHAR2(5) NOT NULL -- ����Ÿ�Թ�ȣ,
  ,	PACK_TYPE_NAME VARCHAR2(20) NOT NULL -- ����Ÿ���̸�
  
  , CONSTRAINT PK_PACKING PRIMARY KEY(PACK_TYPE_NO)
);
-- ��ǰī�װ�
CREATE TABLE ITEM_CATEGORY (
	ITEM_CATEGORY_NO VARCHAR2(10) NOT NULL -- ī�װ���ȣ,
  ,	ITEM_CATEGORY_NAME VARCHAR2(20) NOT NULL -- ī�װ��̸�,
  ,	EXPIRATION_DATE VARCHAR2(20) -- �������,
  ,	NOTICE VARCHAR2(500) NOT NULL -- �ȳ�����,
  ,	FRESH_PERCENT NUMBER(4,1) NULL -- �ż���,
  ,	PACK_TYPE_NO VARCHAR2(5) NOT NULL -- ����Ÿ�Թ�ȣ
  
  , CONSTRAINT PK_ITEM_CATEGORY PRIMARY KEY(ITEM_CATEGORY_NO)
  , CONSTRAINT FK_PACK_TO_ITEM_CATE FOREIGN KEY(PACK_TYPE_NO) REFERENCES PACKING(PACK_TYPE_NO) ON DELETE CASCADE
);
-- ��ǰ
CREATE TABLE ITEM (
	ITEM_NO VARCHAR2(20) NOT NULL -- ��ǰ��ȣ,
  ,	SELLER_ID varchar2(50) NOT NULL -- �Ǹ���ȸ�����̵�,
  ,	ITEM_NAME VARCHAR2(50) NOT NULL -- ��ǰ��,
  ,	ITEM_PRICE NUMBER(8) NOT NULL -- �ǸŰ�,
  ,	SALES_UNIT VARCHAR2(20) NULL -- �ǸŴ���,
  ,	ITEM_ORIGIN VARCHAR2(20) NOT NULL -- ������,
  ,	ITEM_STOCK NUMBER(3,0) NOT NULL -- ���,
  ,	ITEM_IMG VARCHAR2(200) NOT NULL -- ��ǰ�̹���,
  ,	ITEM_CUST_SCORE NUMBER(3,1) NOT NULL -- ������,
  ,	ITEM_INPUT_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- �������,
  ,	DISC_RATE NUMBER(3,0) NULL -- ������,
  ,	ITEM_TAKEIT CHAR(1) DEFAULT 'F' NOT NULL -- �հŷ�����,
  ,	ITEM_CATEGORY_NO VARCHAR2(10) NOT NULL -- ī�װ���ȣ
  
  , CONSTRAINT PK_ITEM PRIMARY KEY(ITEM_NO)
  , CONSTRAINT FK_ITEM_CATE_TO_ITEM FOREIGN KEY(ITEM_CATEGORY_NO) REFERENCES ITEM_CATEGORY(ITEM_CATEGORY_NO) ON DELETE CASCADE
  , CONSTRAINT FK_SEL_MEMB_TO_ITEM FOREIGN KEY(SELLER_ID) REFERENCES SELLER(SELLER_ID) ON DELETE CASCADE
);
-------------------------------------------------------------------------------
-- ��ۻ���
CREATE TABLE SHIPPING (
	SHIP_STATUS_CODE VARCHAR2(10) NOT NULL -- ��ۻ����ڵ�,
  ,	SHIP_STATUS VARCHAR2(20) NOT NULL -- ��ۻ����̸�
  
  , CONSTRAINT PK_SHIPPING PRIMARY KEY(SHIP_STATUS_CODE)
);
-- �ֹ�
CREATE TABLE ORDERS (
	ORDER_NO VARCHAR2(20) NOT NULL -- �ֹ���ȣ,
  ,	RECEIVE_METHOD VARCHAR2(20) NOT NULL -- ���ɹ��,
  ,	RECIPIENT_NAME VARCHAR2(50) NOT NULL -- ������,
  ,	RECIPIENT_POSTNO CHAR(5) NULL -- �����ο����ȣ,
  ,	RECIPIENT_ADDR VARCHAR2(500) NULL -- ������ ���ּ�,
  ,	RECIPIENT_MOBILE CHAR(13) NOT NULL -- ������ ����ó,
  ,	SHIP_REQUEST VARCHAR2(100) NULL -- ��ۿ�û����,
  , ORDER_PRICE NUMBER(10) NOT NULL -- ���ֹ��ݾ�
  , ORDER_CANCEL_REQ CHAR(1) DEFAULT 'F' -- �ֹ���ҿ�û
  , ORDER_CANCEL CHAR(1) DEFAULT 'F' --�ֹ����
  ,	SHIP_STATUS_CODE VARCHAR2(10) NULL -- ��ۻ����ڵ�,
  ,	MEMBER_ID varchar2(50) NULL -- �Ϲ�ȸ�����̵�

  
  , CONSTRAINT PK_ORDERS PRIMARY KEY(ORDER_NO)
  , CONSTRAINT FK_SHIP_TO_ORDERS FOREIGN KEY(SHIP_STATUS_CODE) REFERENCES SHIPPING(SHIP_STATUS_CODE) ON DELETE CASCADE
  , CONSTRAINT FK_GEN_MEMB_TO_ORDERS FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE
);
-- �ֹ���ǰ��
CREATE TABLE ORDER_DETAIL (
	ITEM_NO VARCHAR2(20) NOT NULL -- ��ǰ��ȣ,
  ,	ORDER_NO VARCHAR2(20) NOT NULL -- �ֹ���ȣ,
  ,	ITEM_QTY NUMBER(3) NOT NULL -- ��ǰ�ֹ�����
  ,	ITEM_PAY_PRICE NUMBER(10) NOT NULL
  
  , CONSTRAINT PK_ORDER_DETAIL PRIMARY KEY(ITEM_NO, ORDER_NO)
  , CONSTRAINT FK_ITEM_TO_ORDER_DETAIL FOREIGN KEY(ITEM_NO) REFERENCES ITEM(ITEM_NO) ON DELETE CASCADE
  , CONSTRAINT FK_ORDERS_TO_ORDER_DETAIL FOREIGN KEY(ORDER_NO) REFERENCES ORDERS(ORDER_NO) ON DELETE CASCADE
);
-------------------------------------------------------------------------------
-- �հŷ�
CREATE TABLE TAKEIT (
	TAKEIT_NO VARCHAR2(20) NOT NULL -- �հŷ���ȣ,
  ,	TAKEIT_PRICE NUMBER(10,0) NOT NULL -- �����ݾ�,
  , TAKEIT_CURR_PRICE NUMBER(10,0) DEFAULT 0 NOT NULL -- ���� ������ �ݾ�
  ,	TAKEIT_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- ������������,
  ,	TAKEIT_CUST_SCORE NUMBER(3,1) DEFAULT 5.0 NOT NULL -- ������,
  ,	TAKEIT_ALIVE CHAR(1) DEFAULT 'T' NOT NULL -- �հŷ����࿩��,
  ,	MEMBER_LOC_NO VARCHAR2(10) NOT NULL -- ȸ��������ȣ,
  ,	SHOP_LOC_CODE VARCHAR2(10) NOT NULL -- ���������ڵ�
 
 
  , CONSTRAINT PK_TAKEIT PRIMARY KEY(TAKEIT_NO)
  , CONSTRAINT FK_MEMB_LOC_TO_TAKEIT FOREIGN KEY(MEMBER_LOC_NO, SHOP_LOC_CODE) REFERENCES MEMBER_LOC(MEMBER_LOC_NO, SHOP_LOC_CODE) ON DELETE CASCADE
);

-- �հŷ��ֹ����
CREATE TABLE TAKEIT_DETAIL (
	TAKEIT_NO VARCHAR2(20) NOT NULL -- �հŷ���ȣ,
  ,	ORDER_NO VARCHAR2(20) NOT NULL -- �ֹ���ȣ,
  
  , CONSTRAINT PK_TAKEIT_DETAIL PRIMARY KEY(TAKEIT_NO, ORDER_NO)
  , CONSTRAINT FK_ORDERS_TO_TAKEIT_D FOREIGN KEY(ORDER_NO) REFERENCES ORDERS(ORDER_NO) ON DELETE CASCADE
  , CONSTRAINT FK_TAKEIT_TO_TAKEIT_D FOREIGN KEY(TAKEIT_NO) REFERENCES TAKEIT(TAKEIT_NO) ON DELETE CASCADE
);
-------------------------------------------------------------------------------
-- �Խñ� ī�װ�
CREATE TABLE BOARD_CATEGORY (
	BOARD_CATEGORY_NO VARCHAR2(10) NOT NULL -- �Խñ� ī�װ� ��ȣ,
  ,	BOARD_CATEGORY VARCHAR2(50) NOT NULL -- �Խñ� ī�װ��̸�
  
  , CONSTRAINT PK_BOARD_CATEGORY PRIMARY KEY (BOARD_CATEGORY_NO)
);
-- �Խñ�
CREATE TABLE BOARD (
	BOARD_NO VARCHAR2(20) NOT NULL -- �Խñ۹�ȣ,
  ,	BOARD_WRITER varchar2(50) NOT NULL -- �ۼ��ھ��̵�
  ,	BOARD_TITLE VARCHAR2(100) NOT NULL -- �Խñ� ����,
  ,	BOARD_CONTENTS VARCHAR2(1000) NOT NULL -- �Խñ� ����,
  ,	BOARD_VIEWS NUMBER(10)DEFAULT 0 NULL -- �Խñ� ��ȸ��,
  ,	BOARD_PICKS NUMBER(10) DEFAULT 0 NULL -- �Խñ� ��õ��,
  ,	BOARD_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- �Խñ� �ۼ�����,
  ,	BOARD_CATEGORY_NO VARCHAR2(10) NOT NULL -- �Խñ� ī�װ� ��ȣ,
  ,	ITEM_NO VARCHAR2(20) NULL -- ��ǰ��ȣ,

  , CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_NO)
  , CONSTRAINT FK_BOARD_CATE_TO_BOARD FOREIGN KEY(BOARD_CATEGORY_NO) REFERENCES BOARD_CATEGORY(BOARD_CATEGORY_NO) ON DELETE CASCADE
  , CONSTRAINT FK_ITEM_TO_BOARD FOREIGN KEY(ITEM_NO) REFERENCES ITEM(ITEM_NO) ON DELETE CASCADE
);

    
-- �ı�
CREATE TABLE REVIEW (
    REVIEW_NO VARCHAR2(20) NOT NULL -- �ı� ��ȣ
  , MEMBER_ID VARCHAR2(50) NOT NULL --�Ϲ�ȸ�����̵�
  , ITEM_NO VARCHAR2(50) NOT NULL -- ��ǰ��ȣ
  , REVIEW_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL -- �ı� �������
  , REVIEW_TITLE VARCHAR2(500) NOT NULL --�ı�����
  , REVIEW_CONTENTS VARCHAR2(2000) NOT NULL --�ı⳻��
  , REVIEW_VIEWS NUMBER(10)DEFAULT 0 NULL -- �ı� ��ȸ��,
  , REVIEW_SCORE NUMBER(3,1) DEFAULT 0.0 NOT NULL -- �ı� ����
  , REVIEW_IMG VARCHAR2(200) NULL -- �ı����
  
  , CONSTRAINT PK_REVIEW PRIMARY KEY(REVIEW_NO)
  , CONSTRAINT FK_REVIEW_MEMB_ID FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE
  , CONSTRAINT FK_REVIEW_ITEM_NO FOREIGN KEY(ITEM_NO) REFERENCES ITEM(ITEM_NO)  ON DELETE CASCADE
);
-------------------------------------------------------------------------------
-- ��ٱ���
CREATE TABLE CART (
	MEMBER_ID varchar2(50) NOT NULL -- �Ϲ�ȸ�����̵�,
  ,	ITEM_NO VARCHAR2(20) NOT NULL -- ��ǰ��ȣ,
  , CART_ITEM_QTY NUMBER(3) DEFAULT 1 NOT NULL
  
  , CONSTRAINT PK_CART PRIMARY KEY(MEMBER_ID, ITEM_NO)
  , CONSTRAINT FK_ITEM_TO_CART FOREIGN KEY(ITEM_NO) REFERENCES ITEM(ITEM_NO) ON DELETE CASCADE
  , CONSTRAINT FK_GEN_MEMB_TO_CART FOREIGN KEY(MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE
);

-------------------------------------------------------------------------------
DELETE FROM TAKEIT_DETAIL;
DELETE FROM TAKEIT;

DELETE FROM ORDER_DETAIL;
DELETE FROM ORDERS;
DELETE FROM SHIPPING;

DELETE FROM ITEM;
DELETE FROM ITEM_CATEGORY;
DELETE FROM PACKING;

DELETE FROM MEMBER;
DELETE FROM SELLER;
DELETE FROM MEMBER_LOC;
DELETE FROM SHOP_CATEGORY;
DELETE FROM SHOP_LOC;

DELETE FROM BOARD;
DELETE FROM BOARD_CATEGORY;
DELETE FROM CART;
DELETE FROM REVIEW;
--------------------------------------------------------------------------------
-- ��������
insert into shop_loc values('AA','��õ�������', '37.49443088673744', '126.72644033165483');
insert into shop_loc values('BB','���ǽŻ����', '37.48323023600057', '126.94495606499854');
insert into shop_loc values('CC','�����߾ӽ���', '33.49168531385225', '126.50887179570302');
--SELECT * FROM SHOP_LOC;
--����ī�װ�
insert into shop_category values('1','��ä');
insert into shop_category values('2','����');
insert into shop_category values('3','����');
insert into shop_category values('4','�ع���');
insert into shop_category values('5','��');
insert into shop_category values('6','����ǰ');
insert into shop_category values('7','���̽�ũ��');
--SELECT * FROM S HOP_CATEGORY;

--ȸ������
--insert into MEMBER_LOC values('29','AA','��õ�� ����');
--insert into MEMBER_LOC values('30','BB','����� ���빮��');
--SELECT * FROM MEMBER_LOC;
BEGIN
FOR i IN 0..99 LOOP 
INSERT INTO MEMBER_LOC VALUES (i, 'AA' , 'AA-'||i);
END LOOP;
END;
--
BEGIN
FOR i IN 0..99 LOOP 
INSERT INTO MEMBER_LOC VALUES (i, 'BB' , 'BB-'||i);
END LOOP;
END;

--�Ϲ�ȸ��
INSERT INTO MEMBER VALUES('user01', 'password01', 'ȫ�浿', '010-1111-1111', 'user01@takeit.com', '2021-04-30', 12345, '��õ�� ����', '�¸�ȣ����Ʈ 309�� 502ȣ', 'G', 1000, '1987-05-05', '29', 'AA'); 
INSERT INTO MEMBER VALUES('user02', 'password02', '������', '010-2222-2222', 'user02@takeit.com', '2020-05-13', 56789, '����� ���빮��', '�عٶ�����Ʈ 1209�� 706ȣ', 'G', 89000, '1997-07-06', '30', 'BB'); 
INSERT INTO MEMBER VALUES('user03', 'password03', '������', '010-3333-3333', 'user03@takeit.com', '2021-02-27', 98765, '����� ����', '�Ȱ����̾���Ʈ 110�� 208ȣ', 'G', 5000, '1987-05-05', '29', 'AA'); 
INSERT INTO MEMBER VALUES('admin', 'adminpass99', '������', '010-9999-9999', 'admin@takeit.com', '2014-02-27', 45678, '����� ���Ǳ�', '���ھ��ھ���Ʈ 807�� 1302ȣ', 'A', 0, '1995-12-05', '30', 'BB'); 
--SELECT * FROM GENERAL_MEMBER;

--�Ǹ���ȸ��
INSERT INTO SELLER VALUES('seller01', 'password01', '�ɼ���', '010-1234-1111', 'seller01@takeit.com', '2021-02-27', 98765, '��õ�� ����', '�������', 'S', '456-78-90123', '010-1111-1234', '�����̳� ��ä����', 9.8, NULL, 'shopImg1.jpg', '1', 'AA'); 
INSERT INTO SELLER VALUES('seller02', 'password02', '���°�', '010-1234-2222', 'seller02@takeit.com', '2021-04-30', 12345, '����� ���빮��', '���빮����', 'S','123-45-67890', '010-2222-1234', '�°��̳� ���ϰ���', 9.3, NULL, 'shopImg2.jpg', '2', 'BB'); 
INSERT INTO SELLER VALUES('seller03', 'password03', '�ӿ���', '010-1234-3333', 'seller03@takeit.com', '2019-06-30', 95123, '����� ���빮��', '���빮����', 'S','748-59-61230', '010-3333-1234', '�����̳� ������', 9.3, NULL, 'shopImg3.jpg', '3', 'BB'); 
INSERT INTO SELLER VALUES('seller04', 'password04', '�Ѽ���', '010-1234-4444', 'seller04@takeit.com', '2020-12-13', 56789, '��õ�� ������', '��������', 'S', '968-57-41302', '010-4444-1234', '����� ��������', 9.5, NULL, 'shopImg4.jpg', '4', 'AA'); 
INSERT INTO SELLER VALUES('seller05', 'password05', '��ȿ��', '010-1234-5555', 'seller05@takeit.com', '2020-05-13', 56789, '��õ�� ����', '�������', 'S', '987-65-43210', '010-5555-1234', 'ȿ���̳� �Ұ���', 9.7, NULL, 'shopImg5.jpg', '5', 'AA'); 
INSERT INTO SELLER VALUES('seller06', 'password06', '���߱�', '010-1234-6666', 'seller06@takeit.com', '2021-05-08', 56789, '��õ�� ����', '�������', 'S', '456-65-21210', '010-6666-1234', '�߱�� ��������', 9.2, NULL, 'shopImg6.jpg', '6', 'AA'); 
INSERT INTO SELLER VALUES('seller07', 'password07', '���¸�', '010-1234-7777', 'seller07@takeit.com', '2019-07-30', 95123, '����� ���빮��', '���빮����', 'S','348-59-69870', '010-7777-1234', '�¸��� ���̽�', 8.9, NULL, 'shopImg7.jpg', '7', 'BB'); 

--SELECT * FROM SELLER_MEMBER;
--------------------------------------------------------------------------------
--�����ʱ�ȭ������--
INSERT INTO  packing VALUES ('re789','��������');
INSERT INTO  packing VALUES ('ic789','�õ�����');
INSERT INTO  packing VALUES ('ro123','�������');
INSERT INTO  packing VALUES ('el456','��Ÿ');

--��ǰī�װ� ������--
INSERT INTO ITEM_CATEGORY  VALUES ('ve','��ä','14','�������ϳ��� �������ּ���',95,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('fr','����','14','�������ϳ��� �������ּ���',98,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('ri','���','150','��º��� ���ּ���',97,'ro123');
INSERT INTO ITEM_CATEGORY  VALUES ('dr','����','7','���庸�� ���ּ���',95,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('mi','����ǰ','7','�˷����⼺�� Ȯ�����ּ���', 100,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('me','����','7','���� �������ּ���',96,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('sd','������','14','���� �������ּ���',96,'re789');
INSERT INTO ITEM_CATEGORY  VALUES ('ic','���̽�ũ��','30','�õ� �������ּ���',96,'ic789');

--��ǰ �ʱ�ȭ������--
--SELECT * FROM ITEM;
INSERT INTO  item  VALUES ('VG'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller01', '����Ű�� ����', 4000, '500g', '����', 8, 'VG'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 8.6, '2021-04-29', 2, 'F','ve');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '��ŭ�� ����', 4000, '500g', '����', 3, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.3, '2021-04-30', 7, 'F','fr');
INSERT INTO  item  VALUES ('BF'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller03', '1��� ���� �ѿ�', 30000, '300g', '����', 6, 'BF'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 8.7, '2021-04-28', 5, 'F','me');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '���ִ� ���������', 4000, '300g', '����', 5, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.5, '2021-05-01', 5, 'F','sd');
INSERT INTO  item  VALUES ('RC'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller05', '����� ������', 6000, '1kg', '����', 7, 'RC'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.8, '2021-04-01', 3, 'F','ri');

INSERT INTO  item  VALUES ('IC'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller07', '�� ���̽�ũ��', 2000, '1��', '����', 11, 'IC'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.5, '2021-05-09', 3, 'F','ic');
INSERT INTO  item  VALUES ('MI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller06', 'Ŀ�ǿ���', 1200, '1��', '����', 8, 'MI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 8.8, '2021-05-09', 4, 'F','mi');
INSERT INTO  item  VALUES ('RI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller05', '�߾�����', 7000, '1kg', '����', 30, 'RI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.8, '2021-05-09', 5, 'F','ri');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '�������� �������', 4500, '500g', '����', 40, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 8.8, '2021-05-09', 6, 'F','sd');
INSERT INTO  item  VALUES ('ME'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller03', '���ű��', 8000, '1kg', 'ȣ��', 22, 'ME'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.1, '2020-05-08', 7, 'F','me');
INSERT INTO  item  VALUES ('IC'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller07', '�ķ�Ʈ��', 2000, '1kg', '����', 9, 'IC'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.2, '2020-05-08', 8, 'F','ic');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '�� ���� ����', 15900, '1kg', '����', 10, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.3, '2021-05-08', 1, 'F','fr');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '���޴��� ����', 6000, '500G', '����', 15, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.4, '2021-05-07', 9, 'F','fr');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '������ ��������', 5000, '350G', '����', 10, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.5, '2021-05-06', 10, 'F','sd');
INSERT INTO  item  VALUES ('ME'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller03', '����� ����', 21000, '1kg', '����', 22, 'ME'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.8, '2021-05-05', 5, 'F','me');
INSERT INTO  item  VALUES ('RI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller05', '�� ������ ��̽�', 9500, '1kg', '����', 33, 'RI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.9, '2021-05-04', 4, 'T','ri');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '�ʱ��ʱ� ����', 8000, '2����', '����', 11, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.0, '2021-05-09', 3, 'T','fr');


INSERT INTO  item  VALUES ('IC'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller07', '�ű׳� ���̽�ũ��', 5000, '2����', '�̱�', 5, 'IC'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.5, '2021-05-01', 5, 'T','ic');
INSERT INTO  item  VALUES ('MI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller06', '���̸�Ʋ ���Ʈ', 3500, '250g', '����', 9, 'MI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.4, '2021-05-05', 7, 'T','mi');
INSERT INTO  item  VALUES ('MI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller06', '���� �䱸��Ʈ', 2900, '5��', '����', 8, 'MI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 8.7, '2021-05-06', 5, 'T','mi');
INSERT INTO  item  VALUES ('MI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller06', '����§ ����� ����', 4000, '500ml', '����', 6, 'MI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 8.4, '2021-05-08', 0, 'T','mi');
INSERT INTO  item  VALUES ('VE'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller01', '�ѳ��Ļ� ������', 5500, '500g', '����', 10, 'VE'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpg', 9.1, '2021-05-08', 4, 'T','ve');


INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '���� ���� ���Ű��', 1500, '1��', '����', 22, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.8, '2021-05-10', 5, 'F','fr');
INSERT INTO  item  VALUES ('RI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller05', '����� ���', 9000, '1kg', '����', 15, 'RI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.5, '2021-05-10', 6, 'F','ri');
INSERT INTO  item  VALUES ('ME'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller03', '���޾�� ��������', 18000, '1kg', '����', 32, 'ME'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.4, '2021-05-10', 9, 'F','me');
INSERT INTO  item  VALUES ('IC'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller07', '���Դ� ���� ���̽�ũ��', 4000, '1��', '����', 42, 'IC'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.9, '2021-05-09', 7, 'F','ic');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '���߸��� ������', 3500, '300g', '����', 19, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.2, '2021-05-09', 10, 'F','sd');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '���� ������', 2500, '1��', '����', 28, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.5, '2021-05-10', 8, 'F','fr');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '��ä', 4000, '400g', '����', 24, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.4, '2021-05-10', 0, 'F','sd');
INSERT INTO  item  VALUES ('FR'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller02', '�ƻ��� ����', 2000, '1��', '����', 22, 'FR'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.3, '2021-05-08', 0, 'F','fr');
INSERT INTO  item  VALUES ('RI'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller05', '�Ѹ�����', 6000, '500g', '����', 33, 'RI'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.2, '2021-05-09', 4, 'F','ri');
INSERT INTO  item  VALUES ('SD'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '�ı�ġ', 5000, '500g', '����', 11, 'SD'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.2, '2021-05-09', 5, 'F','sd');
INSERT INTO  item  VALUES ('ME'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller04', '���ִ� ������', 12000, '600g', 'ȣ��', 25, 'ME'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.2, '2021-05-07', 5, 'F','me');
INSERT INTO  item  VALUES ('VG'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller01', '����', 4000, '1��', '����', 8, 'VG'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 8.6, '2021-05-10', 2, 'F','ve');
INSERT INTO  item  VALUES ('VG'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller01', '����',1800, '1��', '����', 17, 'VG'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.8, '2021-05-10',3, 'F','ve');
INSERT INTO  item  VALUES ('VG'||LPAD(ITEM_SEQ.NEXTVAL,6,'0'),'seller01', '�ƻ�ƻ� ���', 1500, '1��', '����', 20, 'VG'||LPAD(ITEM_SEQ.CURRVAL,6,'0')||'.jpeg', 9.3, '2021-05-10', 3, 'F','ve');
--------------------------------------------------------------------------------
--����ڵ� �ʱ�ȭ������
INSERT INTO SHIPPING VALUES('O-GET','�ֹ�����');
INSERT INTO SHIPPING VALUES('I-GET','��ǰ�μ�');
INSERT INTO SHIPPING VALUES('I-MOVE','��ǰ�̵���');
INSERT INTO SHIPPING VALUES('S-ARR','���������');
INSERT INTO SHIPPING VALUES('S-GO','������');
INSERT INTO SHIPPING VALUES('DONE','��޿Ϸ�');

--�ֹ� �ʱ�ȭ������--
--INSERT INTO ORDERS VALUES ('F210305000001', '�湮����', 'ȫ�浿', null, null, '010-1111-1111', null, 7440, 'F', 'F', null, 'user01');
--INSERT INTO ORDERS VALUES ('T210501000004', '���', '�ʰ���', '57689', '��õ�� ����', '010-1234-4444', '���ǿ� �ð��ּ���', 4000, 'F', 'F', 'O-GET', 'user01');
--INSERT INTO ORDERS VALUES ('T210501000003', '���', '�ʿ���', '12365', '��õ�� ����', '010-1234-3333', '�� �տ� �ΰ� ������', 8000, 'F', 'F', 'O-GET', 'user03');
--INSERT INTO ORDERS VALUES ('T210501000005', '���', '�ʿ���', '14151', '��õ�� ����', '010-1234-5555', '���� 4�ÿ� ì�ܰ��Կ�', 6000, 'F', 'F', 'O-GET', 'user03');
--
--INSERT INTO ORDERS VALUES ('T210501000001', '���', '�Ѱܿ�', '12345', '����� ���빮��', '010-1515-1515', '�� ��', 32000, 'F', 'F', 'O-GET', 'user02');
--INSERT INTO ORDERS VALUES ('T210501000002', '���', '�ʰ���', '13451', '����� ���빮��', '010-1234-2222', '���� �ż��� ������ ì���ּ���', 10000, 'F', 'F', 'O-GET', 'user02');

--�ֹ��� �ʱ�ȭ������--
--INSERT INTO ORDER_DETAIL VALUES('SD000001', 'F210305000001', 2, 3720);
--
--INSERT INTO ORDER_DETAIL VALUES('FR000002', 'T210501000001', 1, 3000);
--INSERT INTO ORDER_DETAIL VALUES('BF000003', 'T210501000001', 1, 29000);
--INSERT INTO ORDER_DETAIL VALUES('FR000007', 'T210501000002', 2, 4000);
--INSERT INTO ORDER_DETAIL VALUES('BF000008', 'T210501000002', 1, 30000);
--
--INSERT INTO ORDER_DETAIL VALUES('VG000004', 'T210501000003', 1, 5000);
--INSERT INTO ORDER_DETAIL VALUES('SD000006', 'T210501000003', 1, 3000);
--INSERT INTO ORDER_DETAIL VALUES('VG000004', 'T210501000004', 1, 4000);
--INSERT INTO ORDER_DETAIL VALUES('RC000005', 'T210501000005', 1, 6000);

--------------------------------------------------------------------------------
--�հŷ� �ʱ�ȭ������--
--INSERT INTO TAKEIT VALUES('TAKE210501000001', 1000000, 50000, '2021/05/01 18:45:10', 0.0, 'T', '29', 'AA');
--INSERT INTO TAKEIT VALUES('TAKE210506000001', 1000000, 50000, '2021/05/06 00:45:10', 0.0, 'T', '30', 'BB');
BEGIN
FOR i IN 0..99 LOOP 
INSERT INTO TAKEIT VALUES ('TAKE' || '210506' || LPAD(TAKEIT_SEQ.NEXTVAL, 6, '0'), 1000000 ,0 ,'2021/05/06 18:45:10', 0.0, 'T', i,'AA');
END LOOP;
END;

BEGIN
FOR i IN 0..99 LOOP 
INSERT INTO TAKEIT VALUES ('TAKE' || '210509' || LPAD(TAKEIT_SEQ.NEXTVAL, 6, '0'), 1000000 ,0 ,'2021/05/09 00:45:10', 0.0, 'T', i,'BB');
END LOOP;
END;

--�հŷ��� �ʱ�ȭ������
--INSERT INTO TAKEIT_DETAIL VALUES('TAKE210506000101', 'T210501000001');
--INSERT INTO TAKEIT_DETAIL VALUES('TAKE210506000101', 'T210501000002');
--
--INSERT INTO TAKEIT_DETAIL VALUES('TAKE210501000001', 'T210501000003');
--INSERT INTO TAKEIT_DETAIL VALUES('TAKE210501000001', 'T210501000004');
--INSERT INTO TAKEIT_DETAIL VALUES('TAKE210501000001', 'T210501000005');
--------------------------------------------------------------------------------
--�Խ��� ī�װ�
INSERT INTO BOARD_CATEGORY VALUES ('1','��������');
INSERT INTO BOARD_CATEGORY VALUES ('2','�����ϴ�����');
INSERT INTO BOARD_CATEGORY VALUES ('3','��ǰ����');

--�Խ���
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'admin', '���� ������Ʈ ���� ����', '2021�� 05�� 02�� ����2�ð� ������Ʈ �����Դϴ�. ���� �̿뿡 �����Ͻʽÿ�.-��-', 10, null, '2021-04-30', '1', null);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'admin', '��й�ȣ�� �缳���ϰ� �;��', '���������� >> ��������ȸ >> ��й�ȣ ���� ������ �Ϸ��Ͻʽÿ�.-��-', null, null, '2020-05-30', '2', null);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'user01', '�°��̳� ���ϰ��� ���� ���� �����', '100g������ �������� �����ϳ���?', 2, null, '2021-05-01', '3', 'FR000002');
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'seller02', '[�亯]�°��̳� ���ϰ��� �� ���� �����', '��, �����մϴ�. �ڼ��� ������ ���Է� �����ּ���. ��ȣ��:�°��̳� ���ϰ���, ����ó: 010-1111-1234', 5, null, '2021-05-02', '3', 'FR000002');
--SELECT * FROM ITEM;
--�ı�
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user01', 'SD000004', '2021-05-03', '����� ����� ���־��', '�Ը� ���� �� �������� �����̿���.', 338, 10.0, 'SD000004.jpg');
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user01', 'VG000001', '2021-05-03', '�����̳� ��ä���Դ� �ϰ� �絵 �˴ϴ�', '���� �ΰ��ѵ� �����̳� ��ǰ�� ������ �������� �ʰ� �絵 �ż� �ֿ��ϰ� �־��.', 127, 10.0, 'VG000001.jpg');
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user02', 'FR000002', '2021-05-03', '�°��̳� ���� ��õ�ؿ�!', '�˵� ���ϰ� ��ŭ�ؼ� ������ �ʴ��󱸿� �������� 1Ű�� �췡�� ����', 110, 10.0, 'FR000002.jpg');
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user02', 'FR000002', '2021-05-03', '�ڲ� �������� �°��̳� ����!', '��Ų �� �� ���ڸ��� �� ���׾�� �±��Դϴ�', 523, 10.0, 'FR000002.jpg');
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user03', 'BF000003', '2021-05-03', '�����̳� ������ ���� �����̳׿�', '�����Ļ� �� �������� �ֹ��ߴµ� 200%�����̿�', 240, 10.0, 'BF000003.jpg');
INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, 'user03', 'RC000005', '2021-05-03', 'ȿ���̳� ���� ���ƿ�', '�� ���� ���� ���� ����ؿ�. ����Ƽ �Ű澲�ŵ��. �ٵ� ����� �� �ʾ 1�� ���Կ�', 107, 9.0, 'RC000005.jpg');
--------------------------------------------------------------------------------
-- ��ٱ���
INSERT INTO CART VALUES('user02','MI000007',3);
INSERT INTO CART VALUES('user02','BF000003',2);
INSERT INTO CART VALUES('user01','FR000002',3);
INSERT INTO CART VALUES('user01','SD000004',3);

--------------------------------------------------------------------------------
commit;

BEGIN 
    FOR I IN 1..100
    LOOP
    INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'admin', CONCAT('����',I), CONCAT('����',I), I, null, '2021-04-30', '1', null);
    END LOOP;
END;
SELECT * FROM BOARD WHERE BOARD_CATEGORY_NO='1';
COMMIT;