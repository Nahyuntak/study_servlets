<<<<<<< HEAD
<%! int day = 3; %> 
<html> 
   <head><title>IF...ELSE Example</title></head> 
   
   <body>
    <div>
        day value : <%=day%>
    </div>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend</p>
      <% } %>
   </body> 
   
</html>
=======
<% int day=3; %>
    <html>

    <head>
        <title>IF...ELSE Example</title>
    </head>

    <body>
        <div>
            day value : <%= day %>
        </div>
        <% if (day==1 || day==7) { %>
            <p> Today is weekend</p>
            <% } else { %>
                <p> Today is not weekend</p>
                <% } %>
    </body>

    </html>
>>>>>>> 6a22631b7256164ddecc811bd69122c1d85738e0
