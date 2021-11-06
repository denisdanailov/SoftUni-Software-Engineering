function slove(input) {

    input = Number(input);

    for (let index = 0; index < input; index++) {
        
        let star = "";
        let starCount = input;

        while(starCount > 0) {
            star += "* ";
            starCount--;
        }
        console.log(star);
        
        
    }
}

slove(5);