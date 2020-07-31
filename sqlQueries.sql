"1. Who checked out the book 'The Hobbit’?"
answer: Anand Beck
sqlQuery: select name from member where id in(select id from book where title="The Hobbit");

"2. How many people have not checked out anything?"
answer: 37
sqlQuery: select count(id) from member where id not in (select member_id from checkout_item);

"3. What books and movies aren't checked out?"
answer:
1984
Catcher in the Rye
Crouching Tiger, Hidden Dragon
Domain Driven Design
Fellowship of the Ring
Lawrence of Arabia
Office Space
Thin Red Line
To Kill a Mockingbird
Tom Sawyer

sqlQuery:
select title from book where id not in (select book_id from checkout_item where movie_id is null)
UNION
select title from movie where id not in (select movie_id from checkout_item where book_id is null);

"4.Add the book 'The Pragmatic Programmer'"
sqlQuery: insert into book(id, title) values(11,"The Pragmatic Programmer");
"add yourself as a member."
sqlQuery: insert into member(name) values("Yiming Zhang");
"Check out 'The Pragmatic Programmer'."
sqlQuery:insert into checkout_item (book_id, member_id) values(11,43);
"Use your query from question 1 to verify that you have checked it out."
select name from member where id in(select member_id from checkout_item,book where checkout_item.book_id=book.id and book.title="The Pragmatic Programmer");

Who has checked out more than 1 item?
Tip: Research the GROUP BY syntax.
answer:Anand Beck
       Frank Smith
sqlQuery:select name from member where id in(select member_id from checkout_item group by member_id having count(*)>1)

