/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphercaesar;

/**
 *
 * @author Cambaz-Monster
 */
public class decrypt {

    public static final String ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String TR_ALPHABET = "abcçdefgğhıijklmnopqrsştuvyz";
    public static final String ES_ALPHABET = "abcdefghijklmnñopqrstuvwxyz";
    public static final String FR_ALPHABET = "abccçdefgğhıijklmnopqrsştuvyz";
    
    public static String decrypt(String cipherText, int shiftKey, int langID) {
        String ALPHABET = null;
        
        if(langID == 1){
            ALPHABET = ENG_ALPHABET;
        } else if(langID == 2){
            ALPHABET = TR_ALPHABET;
        } else if(langID == 3){
            ALPHABET = ES_ALPHABET;
        } else if(langID == 4){
            ALPHABET = FR_ALPHABET;
        }
        
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
}
