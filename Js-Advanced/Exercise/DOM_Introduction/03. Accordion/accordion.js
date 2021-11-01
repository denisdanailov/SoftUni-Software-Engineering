function toggle() {
    
   const button = document.querySelector(".button");

   button.textContent = button.textContent == "More" ? "Less" : "More";

   const text = document.getElementById("extra");
   text.style.display = "block";

   button.textContent == "More" ? text.style.display = "none" : text.style.display = "block";
}