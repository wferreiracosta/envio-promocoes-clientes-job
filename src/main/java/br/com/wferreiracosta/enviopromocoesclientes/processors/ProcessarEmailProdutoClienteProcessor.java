package br.com.wferreiracosta.enviopromocoesclientes.processors;

import br.com.wferreiracosta.enviopromocoesclientes.domains.InteresseProdutoCliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static java.text.NumberFormat.getCurrencyInstance;

@Component
public class ProcessarEmailProdutoClienteProcessor implements ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> {

    @Override
    public SimpleMailMessage process(InteresseProdutoCliente interesseProdutoCliente) throws Exception {
        final var email = new SimpleMailMessage();
        email.setFrom("xpto@no-reply.com");
        email.setTo(interesseProdutoCliente.getCliente().getEmail());
        email.setSubject("Promoção Imperdivel!!!!");
        email.setText(gerarTextoPromocao(interesseProdutoCliente));

        //Mailtrap não suporta muitos e-mails em um curto espaço de tempo, coloquei um sleep de 2 segundos para enviar tudo
        Thread.sleep(2000);

        return email;
    }

    private String gerarTextoPromocao(InteresseProdutoCliente interesseProdutoCliente) {
        final var writer = new StringBuilder();
        writer.append(format("Olá, %s!\n\n", interesseProdutoCliente.getCliente().getNome()));
        writer.append("Essa promoção pode ser do seu interesse:\n\n");
        writer.append(format("%s - %s\n\n", interesseProdutoCliente.getProduto().getNome(), interesseProdutoCliente.getProduto().getDescricao()));
        writer.append(format("Por apenas: %s!", getCurrencyInstance().format(interesseProdutoCliente.getProduto().getPreco())));
        return writer.toString();
    }

}
