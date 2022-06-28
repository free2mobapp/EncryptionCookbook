=======
Encryption
=======
call encrypt method
public static String[] encrypt(String pText, String key)

generate IV,
convert AES key to SecretKey
call encrypt below
do  Base64 encode the response from below encrypt

public static byte[] encrypt(byte[] pText, SecretKey secret, byte[] iv) throws Exception {
actual encrypt using secret and IV.

==========
Decryption
========

do Base64 decode
call decrypt with
encrypted content, AES Key and IV.
decrypt the content.
  +