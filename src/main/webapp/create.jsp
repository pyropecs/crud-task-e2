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
    <script>
      function ValidateForm(form) {
        const age = Number(document.querySelector("#age").value);
        const rating = Number(document.querySelector("#rating").value);
        let errorMessage;
        let isNotError = true;
        if (age < 0 || isNaN(age)) {
          errorMessage = "Age must be a positive number.";
          const ageErrorElement = document.querySelector("#age-error");
          ageErrorElement.textContent = errorMessage;
          ageErrorElement.style.color = "red";
          isNotError = false;
        }
        if (rating < 0 || isNaN(rating)) {
          errorMessage = "Rating must be a positive number.";
          const ratingErrorElement = document.querySelector("#rating-error");
          ratingErrorElement.textContent = errorMessage;
          ratingErrorElement.style.color = "red";
          isNotError = false;
        }
        return isNotError;
      }
    </script>
  </body>
</html>
