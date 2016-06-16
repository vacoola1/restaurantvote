<html>
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<body>
<div class="alert alert-info">Graduation project

    <h1>Java Enterprise Online Project</h1
    >
    <p>Java Enterprise: Maven/ Spring/ Security/ JPA(Hibernate)/ REST(Jackson)/ Bootstrap(CSS)/ jQuery + plugins.</p>
    <h1><a shape="rect"
           href="https://github.com/JavaWebinar/topjava06/blob/doc/doc/graduation.md#graduation-project"></a>Graduation
        project</h1>
    <p>Design and implement a JSON API using Hibernate/Spring/SpringMVC (or Spring-Boot)&nbsp;<strong>without
        frontend</strong>.</p>
    <p>The task is:</p>
    <p>Build a voting system for deciding where to have lunch.</p>
    <ul>
        <li>2 types of users: admin and regular users</li>
        <li>Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and
            price)
        </li>
        <li>Menu changes each day (admins do the updates)</li>
        <li>Users can vote on which restaurant they want to have lunch at</li>
        <li>Only one vote counted per user</li>
        <li>If user votes again the same day:</li>
        <ul>
            <li>If it is before 11:00 we asume that he changed his mind.</li>
            <li>If it is after 11:00 then it is too late, vote can't be changed</li>
        </ul>
    </ul>
    <p>Each restaurant provides new menu each day.</p>
    <p>As a result, provide a link to github repository. It should contain the code, README.md with API documentation
        and couple curl commands to test it.</p>
    <hr>
    <p>P.S.: Make sure everything works with latest version that is on github :)</p>
    <p>P.P.S.: Asume that your API will used by a frontend developer to build frontend on top of that.</p>
</div>
</body>
</html>