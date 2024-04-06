<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="${employee.id}/edit" method="post">
        <!-- Input fields for editing employee details -->
        Name: <input type="text" name="name" value="${employee.name}"><br>
        Gender: <input type="text" name="gender" value="${employee.gender}"><br>
        Age: <input type="number" name="age" value="${employee.age}"><br>
        Salary: <input type="number" name="salary" value="${employee.salary}"><br>
        <!-- Add more fields as needed -->
        <input type="submit" value="Save">
    </form>
</body>
</html>
