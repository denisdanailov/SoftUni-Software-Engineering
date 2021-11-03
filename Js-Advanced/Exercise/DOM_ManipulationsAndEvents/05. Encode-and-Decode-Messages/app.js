function encodeAndDecodeMessages() {
    
    const message = document.querySelector('textarea');
    const encodeBtn = document.querySelector('button');
    encodeBtn.addEventListener("click",encode);

    const receivedMessage = document.getElementById('No messages...');

   function encode(e) {
    
    receivedMessage.value = message.value;

       
   }
}