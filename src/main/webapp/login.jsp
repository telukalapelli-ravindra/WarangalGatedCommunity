<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>


<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;

    background-image:
    linear-gradient(rgba(0,0,0,0.5),
                    rgba(0,0,0,0.5)),
     url("images/community.jpg");

    background-size:cover;
    background-position:center;
}

.login-container{

    width:400px;

    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(12px);

    border:1px solid rgba(255,255,255,0.2);

    border-radius:20px;

    padding:40px;

    box-shadow:0 8px 32px rgba(0,0,0,0.3);

    color:white;
}

.login-container h1{

    text-align:center;
    margin-bottom:10px;

    color:#ffffff;
}

.subtitle{

    text-align:center;
    margin-bottom:30px;

    color:#dbeafe;
}

label{

    display:block;

    margin-bottom:5px;

    font-weight:600;
}

input[type="email"],
input[type="password"]{

    width:100%;

    padding:12px;

    border:none;

    border-radius:10px;

    margin-bottom:15px;

    background:rgba(255,255,255,0.2);

    color:white;

    outline:none;
}

input::placeholder{

    color:#e5e7eb;
}

.button-group{

    display:flex;
    gap:10px;
}

input[type="submit"]{

    flex:1;

    padding:12px;

    border:none;

    border-radius:10px;

    cursor:pointer;

    font-weight:bold;

    transition:0.3s;
}

input[value="ResidentLogin"]{

    background:#22c55e;
    color:white;
}

input[value="PresidentLogin"]{

    background:#2563eb;
    color:white;
}

input[type="submit"]:hover{

    transform:translateY(-2px);
}

.links{

    margin-top:20px;

    text-align:center;
}

.links a{

    color:#facc15;

    text-decoration:none;

    font-weight:bold;
}

.links a:hover{

    text-decoration:underline;
}

.error{

    color:#ff6b6b;

    text-align:center;

    margin-bottom:15px;

    font-weight:bold;
}

</style>

</head>
<body>

<div class="login-container">

    <h1>Warangal Gated Community</h1>

    <p class="subtitle">Community Management Portal</p>


<%   String message= (String)request.getAttribute("presidentStatusMessage"); %>

<% if(message!=null) { %>

<div class="error">
            <%= message %>
        </div>

<% }%>

  <form action="validateLogin" method="post">

        <label>Email</label>

        <input name="emailId"
               type="email"
               placeholder="Enter Email">

        <label>Password</label>

        <input name="password"
               type="password"
               placeholder="Enter Password">

        <div class="button-group">

            <input name="submit"
                   type="submit"
                   value="ResidentLogin">

            <input name="submit"
                   type="submit"
                   value="PresidentLogin">

        </div>

    </form>
 <div class="links">

        <a href="ResidenceRegister.html">
            New User? Register Here
        </a>

    </div>
</body>
</html>