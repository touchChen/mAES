<?php
$key = "key1234567890key";   // 必须 16、32、64的倍数
$iv     = "iv1234567890iviv";       // 必须 16、32、64的倍数

$arr = ['status' => '999', 'info' => 'success', 'data' => [['id' => 1, 'name' => 'hellcar', '2' => 'dd']]];
$str = json_encode($arr);

$data = $str;

//加密
$encrypted = mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $data,MCRYPT_MODE_CBC, $iv);
$en = base64_encode($encrypted);
echo($en);
echo '<br/>';

//解密
$encryptedData = base64_decode($en);
$decrypted = mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $encryptedData, MCRYPT_MODE_CBC, $iv);
echo($decrypted);
?>

