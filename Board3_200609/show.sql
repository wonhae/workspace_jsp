

rownum은 오라클에만 있고, 조회할때마다 생성되니 별칭을 반드시 만들어야! rnum 값을 찾아서 그만큼 게시글만 가져옴. selec t~이하를 테이블로 쓴다
select * from 
(select rownum rnum, num, title, writer, writeday, readcnt, repIndent from 
(select * from board order by repRoot desc, repStep asc))
where rnum>=1 and rnum <=10

