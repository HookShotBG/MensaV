<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Mensa Voter</title>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="https://intercoolerreleases-leaddynocom.netdna-ssl.com/intercooler-1.2.1.min.js"></script>
  <link rel="stylesheet" 
     href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
    crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
    crossorigin="anonymous"></script>
</head> 

<body>
<div class="panel-heading"><h3 style="text-align: center">Mensa Voter</h3></div>
<div class="list-group">
<#list menus as menu>
  <a class="list-group-item list-group-item-action flex-column align-items-start" data-toggle="collapse" data-target="#detailmenu${menu_index}">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">${menu.title}</h5>
      <small>${menu.type}</small>
    </div>
    <p class="mb-1">${menu.description}</p>
    <div class="d-flex w-100 justify-content-between">
      <small>${menu.prices}</small>
      <span class="badge badge-primary" ic-get-from="/menu/${menu_index}/likes" ic-trigger-on="load" ic-poll="5s"></span>
    </div>
  </a>
  <div id="detailmenu${menu_index}" class="collapse">
    <a class="list-group-item list-group-item-action flex-column align-items-start bg-light" >
     <div class="alert alert-dark" role="alert" ic-get-from="/menu/${menu_index}/comments" ic-poll="5s" ic-trigger-on="load">...</div>
     <div class="row">
       <div class="col-10">
         <form ic-post-to="/menu/${menu_index}/comments" ic-target="#target">
           <div class="input-group mb-3">
             <input type="text" name="comment" class="form-control">
             <div class="input-group-append"><button class="btn btn-outline-secondary">Speichern</button></div>
           </div>
         </form>
       </div> 
       <div class="col-2" style="text-align: right">
         <button ic-post-to="/menu/${menu_index}/likes" class="btn btn-primary" ic-target="#target" >Like</button>
       </div>
     </div>
    </a>
  </div>
 </#list> 
</div>
</body>
</html>