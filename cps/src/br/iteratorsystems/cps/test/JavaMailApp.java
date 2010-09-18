package br.iteratorsystems.cps.test;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp
{
      public static void main(String[] args) {
            Properties props = new Properties();
            /** Par�metros de conex�o com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("sistemacps@gmail.com", "sistemacps2010");
                             }
                        });
            /** Ativa Debug para sess�o */
            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("sistemacps@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinat�rio(s)
                             .parse("vagner.davi@terra.com.br,andresmafra@gmail.com,domingues.santiago@gmail.com,fabio.m.b_afonso@hotmail.com");  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Criamos o email do cps!!");//Assunto
                  message.setText("Pessoal, estou enviando este email com o Java, pois criei o email do cps," +
                  		" para ajuda ao recuperar senha, por exemplo!" +
                  		"\nFavor n�o responder o email.");
                  
                  /**M�todo para enviar a mensagem criada*/
                  Transport.send(message);
                  System.out.println("Feito!!!");
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}