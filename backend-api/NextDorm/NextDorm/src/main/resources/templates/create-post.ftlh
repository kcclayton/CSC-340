<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/create-post.css">
</head>
<body>
    
<!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg ra-navbar">

        <div class="container-fluid">

            <!-- HEADER LOGO -->

            <a class="navbar-brand" href="../Provider/index.html">
                <img src="/images/nextdorm-logo-alt3.png" alt="Logo" width="155" height="55"
                    class="d-inline-block align-text-top">
            </a>

            <!-- COLLAPSE AT SIZE -->

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <!-- SEARCH BAR -->

                <form class="d-flex navbar-search" role="search">

                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                    <button class="btn btn-outline-custom" type="submit">Search</button>

                </form>

                    <a class="navbar-icon" id="profile-icon" href="profile.html">
                        <img src="/images/nextdorm-icon-profile.png" alt="Logo" width="60" height="60"
                            class="d-inline-block align-text-top">
                    </a>

            </div>

        </div>

    </nav>
    <!-- LEFT NAV OPTIONS -->

    <div class="nav-column">

        <!-- MAIN NAV BUTTONS -->

        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            <!-- HOME BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="/students">Home</a>
            </li>

            <!-- ANNOUNCEMENTS BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="../Provider/announcements.html">Announcements</a>
            </li>

            <!-- EVENTS BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="../Provider/events.html">Events</a>
            </li>

    </div>

    <!--Post section-->
       <div class="card-wrapper">
        <div class="card">
            
        <form action="/students/posts/create" method="post">

            <div class="mx-3 mb-3">
                <label class="form-label">Create a Post</label>
                <input type="text" class="form-control" name="postTitle"
                    placeholder="Enter a title for your post">
            </div>


            <div class="dropdown mx-3 mb-3">
            <label class="form-label">
                Select Tag
            </label>
            <select class="form-select" name="postTag">
                <option value="Emergency">Emergency</option>
                <option value="Question">Question</option>
                <option value="Maintenance">Maintenance</option>
                <option value="Issue">Issue</option>
            </select>
            </div>


            <div class="mx-3 mb-3">
                <textarea class="form-control" name="postContent" rows="8"
                    placeholder="Enter content for your post"></textarea>
            </div>


            <button type="submit" class="btn btn-outline-custom" id="post-btn">Post</button>

        </form>


        </div>
    </div>



    
</body>
</html>