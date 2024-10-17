import java.util.List;
import java.io.FileWriter;
import java.nio.file.*;
import java.util.Scanner;


public class CarteiraM{
    
    //Declaracao das variaveis    
    Scanner sc = new Scanner (System.in);
    String contacto;
    String senha;
    int divida;
    double saldo = 0.0;

    //Credenciais de um administrador    
    String contactoAdmin = "847933744";
    String senhaAdmin = "12345";
    
    //Credenciais de um utilizador
    String contactoUser = "843491265";
    String senhaUser = "9090";


    
            //Niveis de Acesso 
            public void login(){

                    
                System.out.println("............. Bem-Vindo a CarteiraM .............");
                System.out.println("Introduza o seu contacto:");
                contacto = sc.nextLine();

                System.out.println("Insira a Senha");
                senha = sc.nextLine();

                    if(contacto.equals(contactoAdmin) && senha.equals(senhaAdmin)){
                        Agente();
                    } else if (contacto.equals(contactoUser) && senha.equals(senhaUser)) {
                        Cliente();
                    }
            }

            
            //Parte do Admin ou Agente
            public void Agente(){
         
                   
                        //Opcoes validas para o agente
                        System.out.println(".......... CarteiraM - Agente ..........");
                        System.out.println("1 - Registar Cliente");
                        System.out.println("2 - Depositar pelo Cliente");
                        System.out.println("3 - Alavancar a Carteira");
                        System.out.println("4 - Visualizar clientes");
                        System.out.println("5 - Depositos Feitos");
                        System.out.println("6 - Sair");
                        
                        
                        int op = sc.nextInt();
                        switch (op) {
                            case 1: 
                                    RegistarCliente();
                                break;

                                case 2: 
                                Depositar();
                                
                                break;

                                case 3: 
                                Alavancar();
                                
                                break;

                                case 4: 
                                        VisualizarUsers();
                                        break;

                                case 5:
                                        Depositos();
                                        break;

                                case 6: 
                                System.out.println("Fechando...");
                            
                            default:
                            System.out.println("Opcao Inválida!");
                                break;
                        }

                    

                 }
                


                

                //metodo para registar cliente
                public void RegistarCliente(){
                    
                    System.out.println("Digite numero do cliente:");
                    contacto = sc.nextLine();

                    System.out.println("Nome do cliente:");
                    String nome = sc.nextLine();

                    System.out.println("Idade:");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Numero de BI:");
                    int BI = sc.nextInt();
                    sc.nextLine(); 

                    System.out.println("Senha:");
                    senha = sc.nextLine();

                    

                    String Dados = "Nome: " +nome+ " Idade: " +idade+ " Numero: " +contacto+ " Numero de BI: " +BI;
                    
                    //Tratando o erro
                    try {
                        FileWriter escrever = new FileWriter("DadosUser.txt");
                        escrever.write(Dados);
                        escrever.close();
                        
                        System.out.println("Cliente Registado com sucesso!");
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Erro ao tentar salvar os dados!");
                        e.printStackTrace();
                    }
                    
                    
                
                }


                //Metodo para depositar
                public void Depositar(){
                        System.out.println("Valor a Depositar:");
                        saldo = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Digite o numero:");
                        contacto = sc.nextLine();        

                        

                        String debit = "Valor depositado: " +saldo+ " para o numero: " +contacto;
                        //Tratando o erro
                    try {
                        FileWriter escrever = new FileWriter("Deposito.txt");
                        escrever.write(debit);
                        escrever.close();
                        System.out.println("Depositado com sucesso!");
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Erro ao registar deposito!");
                        e.printStackTrace();
                    }

                        
                }

                public void Depositos(){
                    Path arq = Paths.get("C:/Users/Cleber Amos Veremach/Desktop/CarteiraM/Deposito.txt");
                    
                    try {
                    
                        List<String> lines = Files.readAllLines(arq);
                
                    for(String line:lines){
                        System.out.println(line);
                    }
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Erro ao ler arquivo.");
                    }
                    
                }



                //Metodo para alvancar
                public void Alavancar(){

                    System.out.println("Valor de alavancagem:");
                    double alavanca = sc.nextDouble();
                }

               //Metodo para ver users
                public void VisualizarUsers(){
                    Path arq = Paths.get("C:/Users/Cleber Amos Veremach/Desktop/CarteiraM/DadosUser.txt");
                    
                    try {
                    
                        List<String> lines = Files.readAllLines(arq);
                
                    for(String line:lines){
                        System.out.println(line);
                    }
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Erro ao ler arquivo.");
                    }
                    
                }


                
                //Menu de utilizador
                public void Cliente(){

                    
                        //Opcoes validas para o agente
                        System.out.println(".......... CarteiraM - Cliente ..........");
                        System.out.println("1 - Levantar Dinheiro");
                        System.out.println("2 - Transferir Dinheiro");
                        System.out.println("3 - Fazer Emprestimo");
                        System.out.println("4 - Pagar Emprestimo");
                        System.out.println("5 - Visualizar Movimentos");
                        System.out.println("6 - Sair");
                        
                        int op = sc.nextInt();

                        switch (op) {
                            case 1: 
                                    Levantar();
                                break;

                                case 2: 
                                Transferir();
                                
                                break;

                                case 3: 
                                Emprestar();
                                
                                break;

                                case 4: 
                                PagarEmp();
                                
                                break;

                                case 5: 
                                Movimentos();
                                
                                break;

                                case 6: 
                                System.out.println("Fechando...");
                                
                                break;

                                
                            default:
                            System.out.println("Opcao Inválida!");
                                break;
                        }
                }
               

            

                //funcao para levantar 
                public void Levantar(){

                    System.out.println("Digite o valor que deseja levantar:");
                    int levantar = sc.nextInt();
                    sc.nextLine();
                }

                
                //Metodo para transferir
                public void Transferir(){

                    System.out.print("Digite o número que pretende transferir: ");
                    String contacto = sc.nextLine();  
            
                    System.out.print("Digite o valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine(); 
            
                    if (valor <= saldo) {
                        saldo -= valor; 
                        System.out.println("Tem certeza que deseja enviar o valor de " + valor + " para o número " + contacto + "?");
                        System.out.println("Saldo atual: " + saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }

                }

                
                //Metodo para fazer emprestimo
                public void Emprestar(){

                    System.out.println("Digite o valor que quer emprestar:");
                    int divida = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Data de Pagamento:");
                    String data = sc.nextLine();

                    System.out.println("Empretimo de" +divida+ "Efectuado!");

                }
                
                public void PagarEmp(){

                    System.out.println("Valor a pagar:");
                    String tako = sc.nextLine();
                }
                

                public void Movimentos(){
                
                }

                public static void main (String [] args){

                    CarteiraM carteira = new CarteiraM();
                    carteira.login();
                }
            }



            //CVeremachi