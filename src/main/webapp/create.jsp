<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>create customer</title>
  </head>
  <body>
    <form action="add" method="post" onsubmit="return ValidateForm(this);">
      <div class="">
        <label for="">enter name</label>
        <input type="text" name="customer_name" />
      </div>
      <div class="">
        <label for="">enter age</label>
        <input type="text" name="customer_age" id="age" />
        <span id="age-error"></span>
      </div>
      <div class="">
        <label for="">enter rating</label>
        <input type="text" name="customer_rating" id="rating" />
        <span id="rating-error"></span>
      </div>

      <button type="submit">create</button>
    </form>
    <script type="text/javascript" src="js/validate.js"></script>

  </body>
</html>
