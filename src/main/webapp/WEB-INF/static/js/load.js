function login(){
    const $key = $('#key').val();
    const $password = $('#pwd').val();
    const key = CryptoJS.enc.Utf8.parse($key);
    const password = CryptoJS.enc.Utf8.parse($password);
    const encrypted = CryptoJS.AES.encrypt(password, key, {mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7});
    const encryptedPwd = encrypted.toString();
    $('#pwd').val(encryptedPwd);
}