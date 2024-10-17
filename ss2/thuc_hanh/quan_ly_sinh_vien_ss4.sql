use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from Subject 
where  credit = (select max(credit) from subject);
	
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select Sub.*
from subject sub
join Mark M on sub.id = M.sub_id
where M.mark = (select Max(mark) from Mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select S.id as StudentID, S.name as StudentName, avg(M.mark) as AverageMark
from Student S
left join Mark M on S.id = M.Student_id
group by S.id
Order by AverageMark desc;
