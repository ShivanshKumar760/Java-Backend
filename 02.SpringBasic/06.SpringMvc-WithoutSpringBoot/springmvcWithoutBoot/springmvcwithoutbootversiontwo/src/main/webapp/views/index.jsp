<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Calculator</h2>

         <form action="addAlien" method="post">
                <label for="aid">Enter Id :</label>
                <input type="text" id="aid" name="aid"><br>
                <label for="aname">Enter Name :</label>
                <input type="text" id="aname" name="aname"><br>
                <input type="submit" value="Submit">
            </form>

         <form action="add" method="post">
                <label for="num1">Enter number 1:</label>
                <input type="text" id="num1" name="num1"><br>
                <label for="num2">Enter number 2 :</label>
                <input type="text" id="num2" name="num2"><br>
                <input type="submit" value="Submit">
            </form>
    </body>
</html>