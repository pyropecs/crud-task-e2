function ValidateForm() {
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