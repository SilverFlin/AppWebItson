const amountIncome = document.getElementById("amountIncome");
const inputIncome = document.getElementById("income");

const createAccountForm = document.getElementById("createAccount");

inputIncome.addEventListener("input", (e) => {
  let currIncome = e.target.value;
  if (currIncome === "100") {
    currIncome = e.target.value + "+";
  }
  amountIncome.innerText = `${currIncome}K`;
});

createAccountForm.addEventListener("submit", (e) => {
  e.preventDefault();
  alert("Form enviado, en consola aparecerá la información");
  const formData = new FormData(e.target);
  console.log(Object.fromEntries(formData));
});
