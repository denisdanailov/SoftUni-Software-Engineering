function slove(a,b,c) {
    
   let aLength = String(a).length;
   let bLength = String(b).length;
   let cLength = String(c).length;

   let result = aLength + bLength + cLength;
   let avarage = Math.floor(result / 3);

   console.log(result);
   console.log(avarage);

    
}

slove('pasta','5','22.3');