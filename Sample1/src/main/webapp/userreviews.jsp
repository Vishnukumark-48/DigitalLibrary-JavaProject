<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Reviews</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            background-image: url(https://images.pexels.com/photos/1097930/pexels-photo-1097930.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
            background-size: cover;
            justify-content: center;
            height: 100vh;
        }

        #content-container {
            text-align: center;
        }

        h2 {
            color: #333;
           
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

    <div id="content-container">
        <h2>User  Reviews</h2>

        <table>
            <tr>
                <th>Username</th>
                <th>Rating</th>
                <th>Review</th>
            </tr>
            <% 
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String dbUrl = "jdbc:mysql://localhost:3306/NGPDB";
                    String dbUname = "root";
                    String dbPassword = "";
                    Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

                    String query = "SELECT * FROM user_reviews";
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        String username = resultSet.getString("username");
                        int rating = resultSet.getInt("rating");
                        String review = resultSet.getString("review");

                        out.println("<tr>");
                        out.println("<td>" + username + "</td>");
                        out.println("<td>" + rating + "</td>");
                        out.println("<td>" + review + "</td>");
                        out.println("</tr>");
                    }

                    statement.close();
                    con.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            %>
        </table>
    </div>

</body>
</html>
