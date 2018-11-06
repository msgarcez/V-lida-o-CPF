/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author msgarcez
 */
public class Cpf {
    static BufferedReader leitura = new BufferedReader(new InputStreamReader (System.in));
    static Scanner entrada = new Scanner(System.in);
    static int[] possCPF = new int[11];

    public static void main(String[] args) throws IOException {
        informe();
        int soma1 = multiplicacao(10);
        int soma2 = multiplicacao(11);
        if (verficador(soma1, 9) && verficador(soma2, 10)){
            System.out.println("CPF Válido!");
        }else{
            System.out.println("CPF Inválido!");
        }
    }

    public static void informe() throws IOException {
        System.out.print("Infome seu CPF: ");
        String cpf = leitura.readLine();
        for (int i = 0; i < possCPF.length; i++) {
            int valor = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            possCPF[i] = valor;
        }
    }

    public static int multiplicacao(int mult) {
        int soma = 0;
        int pos = 0;
        for (int i = mult; i >= 2; i--) {
            soma += possCPF[pos] * i;
            pos++;
        }
        return soma;
    }
    
    public static boolean verficador(int soma1, int mult) {
        int resto = soma1 % 11;
            if (resto < 2) {
                if (possCPF[mult] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                int dig = 11 - resto;
                if(possCPF[mult] == dig){
                    return true;
                }else{
                    return false;
                }
            }
               
    }

}
