show tables;
select * from tb_stu_result;
select * from tb_student;
INSERT INTO tb_stu_result values(1,'english',99);
insert INTO tb_stu_result VALUES(1,'chinese',98);
INSERT INTO tb_stu_result values(2,'english',97);
INSERT INTO tb_stu_result values(2,'chinese',96)

/**
查询出英语最高的分数
*/
SELECT MAX(result) result_name from tb_stu_result WHERE SUBJECT = 'english'
/**
查询出最高分数名字的id
*/
SELECT student_id from tb_stu_result where result = (SELECT MAX(result) result_name from tb_stu_result WHERE SUBJECT = 'english')
/**
查询出分数最高的用户名
*/
SELECT username from tb_student WHERE student_id = (SELECT student_id from tb_stu_result where result = (SELECT MAX(result) result_name from tb_stu_result WHERE SUBJECT = 'english'))
/*
左链接 合并结果集
*/
SELECT tbstu.username,tbresult.result
FROM tb_student tbstu LEFT OUTER JOIN tb_stu_result tbresult 
ON tbstu.student_id = tbresult.student_id 


/**
左链接 标准
*/
SELECT * FROM tb_student tbstu
LEFT OUTER JOIN tb_stu_result tbresult
ON tbstu.student_id = tbresult.student_id
/**
左链接
*/
SELECT * FROM tb_student NATURAL LEFT JOIN tb_stu_result 

SELECT sal+IFNULL(COMM,0) TOTAL FROM emp
SELECT deptno,COUNT(*)
FROM emp
GROUP BY deptno;

SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
HAVING SUM(sal) > 9000;
/**
查询数据
*/
select * from tb_stu_result;
select * from tb_student;
select a.result,b.username from tb_stu_result a,tb_student b;
select a.result,b.username from tb_stu_result a,tb_student b where `subject`='english';  
/**
limit 中0可以省略 降序后显示第一行
*/
select a.result,b.username from tb_stu_result a,tb_student b where `subject`='english' GROUP BY result desc limit 0,1;

select a.result,b.username from tb_stu_result a,tb_student b where a.result=(SELECT MAX(result) result_name from tb_stu_result WHERE SUBJECT = 'english') and 
 a.student_id=b.student_id and a.student_id in (SELECT student_id from tb_stu_result where result = (SELECT MAX(result) result_name from tb_stu_result WHERE SUBJECT = 'english'));
/*
左链接查询
*/
SELECT tbstu.username,tbresult.result
FROM tb_student tbstu LEFT OUTER JOIN tb_stu_result tbresult 
ON tbstu.student_id = tbresult.student_id where tbresult.subject='english' GROUP BY username desc limit 1;