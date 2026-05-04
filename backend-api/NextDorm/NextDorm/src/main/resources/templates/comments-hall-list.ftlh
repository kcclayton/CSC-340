<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Home Page</title>
    <link rel="icon" href="images/nextdorm-logo-alt2.png" type="image/png">

    <!-- BOOTSTRAP -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

    <!-- FONTS -->

    <!-- STYLE SHEET -->

    <link rel="stylesheet" href="/dashboard.css">

</head>

<body>

<!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg ra-navbar">

        <div class="container-fluid">

            <!-- HEADER LOGO -->

            <a class="navbar-brand" href="index.html">
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
            
            <!-- USER BAN BUTTON -->

                <a class="navbar-icon" id="user-ban-icon" href="user-ban-form.html">
                    <img src="/images/nextdorm-icon-user-ban-form.png" alt="Logo" width="60" height="60"
                        class="d-inline-block align-text-top">
                </a>

            <!-- PROFILE BUTTON -->

                <a class="navbar-icon" id="profile-icon" href="profile-edit.html">
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

            <li class="nav-item" style="font-weight: bold;">
                <a class="nav-link" href="/students">Home</a>
            </li>

            <!-- ANNOUNCEMENTS BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="announcements.html">Announcements</a>
            </li>

            <!-- EVENTS BUTTON -->

            <li class="nav-item">
                <a class="nav-link" href="events.html">Events</a>
            </li>

    </div>

<!-- MAIN CONTENT COLUMN -->

    <div class="main-container">

        <!-- MAIN PAGE -->

        <div class="main-wrapper">

            <div class="thing">

            <!-- BUTTON CONTAINER -->

                <ul class="container" id="filter-btn-container">

                    <!-- ALL BUTTON -->

                    <li class="feed-btn">
                        <a class="nav-link" href="/students">All</a>
                    </li>

                    <!-- ANNOUNCEMENTS BUTTON -->

                    <li class="feed-btn">
                        <a class="nav-link" href="#"><b>Your Building</b></a>
                    </li>

                    <!-- EVENTS BUTTON -->

                    <li class="feed-btn">
                        <a class="nav-link" href="#">Important</a>
                    </li>

                    <li class="feed-btn" id="create-post">
                        <a class="nav-link" href="/students/posts/create">Create a Post</a>
                    </li>

                </ul>

                <!-- POST FEED -->

                <div class="card home-feed mx-3">

                <!-- POSTS -->

                <#list commentsHallList as post>
                 <#if post.student??>
                    <div class="card post mx-4 my-2">

                        <ul class="container card-top-section">

                            <li class="card-title post-title">${post.postTitle}</li>
                            
                            <li class="title-info">${post.student.username} | ${post.student.residenceHall} @ ${post.createdAt}</li>
                            <li class="comment-btn">
                                <a href="/students/replies/create/${post.postID}">
                                    <img src="/images/comment-icon.png" alt="Logo" width="30" height="30"
                                        class="d-inline-block align-text-top">
                                </a>
                            </li>

                        </ul>

                        <p class="card-text"><b>${post.postTag}</b> | ${post.postContent}</p>
                        <p class="card-text"><small></small></p>

                    <#list post.replies as reply>
                        <#if reply.student??>
                        <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                            
                            <div class="container comment">

                                <p class="comment-info">${reply.student.username} | ${reply.createdAt}</p>
                                <a class="reply-btn" href="../Customer/reply.html">
                                    <img src="/images/reply-icon.png" alt="Logo" width="20" height="20"
                                        class="d-inline-block align-text-top">
                                </a>

                            </div>

                            <p class="comment-text">${reply.replyContent}</p>

                        </div>
                        </#if>
                    </#list>

                    </div>

                      </#if>
                </#list>


                </div>

        
        </div>

    </div>

</div>




<!-- QUICK LINKS COLUMN -->

    <div class="right-container">

        <div class="quick-links-feed">

        <!-- MAINTENANCE LINK -->

            <div class="card quick-links">

                <div class="card-body" id="fixt-card">
                    
                    <h5 class="card-title">Something broken?</h5>
                    <p class="card-text">Use this form if you are experiencing issues with physical equipment or systems.</p>

                </div>

                <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                    
                    <a href="https://uncg.webtma.com/Login/Validate/?tkn=g6Y25J6P4J0W32tK_JftRhAPjVpjq082kiulXBdor9j0S5lHhkW5q8SlpOO_rsnKUo8IJwwuTdmcR7nZA1DTeXx8IBqj6SvIjMmtD3GcdUHwU_BHSRq4RcfuSMDrsQoUgCt_tlvGkCjjmnuDabXrafABp0LGFY7fg9byqneZdGldqjDaUCKfE2eIyNGGYgX3EoYNXrm3D1C8YarQgyOACluyYuuw3SfZox-K5dHtaf3Dbe5sG4AAXB1RbiGA0MBSzBq9n73xRaWvHkQOvj83Dw" 
                        class="card-link link-underline link-underline-opacity-0">Submit a work request here!</a>
                
                </div>

            </div>

        <!-- HRL LINK -->

            <div class="card quick-links">

                <div class="card-body" id="fixt-card">
                    
                    <h5 class="card-title">Community Guidelines</h5>
                    <p class="card-text">See what all your campus has to offer.</p>

                </div>

                <div class="card-body" id="fixt-link" style="border-top: rgb(215, 215, 215) solid 1px">
                    
                    <a href="https://hrl.uncg.edu" 
                        class="card-link link-underline link-underline-opacity-0">Visit the housing website here!</a>
                
                </div>

            </div>

        </div>

    </div>

</body>