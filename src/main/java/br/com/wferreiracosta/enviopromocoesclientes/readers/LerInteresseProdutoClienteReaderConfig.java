package br.com.wferreiracosta.enviopromocoesclientes.readers;

import br.com.wferreiracosta.enviopromocoesclientes.domains.InteresseProdutoCliente;
import br.com.wferreiracosta.enviopromocoesclientes.utils.mappers.ClienteMapper;
import br.com.wferreiracosta.enviopromocoesclientes.utils.mappers.InteresseProdutoClienteMapper;
import br.com.wferreiracosta.enviopromocoesclientes.utils.mappers.ProdutoMapper;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.wferreiracosta.enviopromocoesclientes.utils.queries.InteresseProdutoClienteQuery.FIND_INTERESSE_PRODUTO_CLIENTE;

@Configuration
public class LerInteresseProdutoClienteReaderConfig {

    @Bean
    public JdbcCursorItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader(
            @Qualifier("appDataSource") DataSource dataSource
    ) {
        return new JdbcCursorItemReaderBuilder<InteresseProdutoCliente>()
                .name("lerInteresseProdutoClienteReader")
                .dataSource(dataSource)
                .sql(FIND_INTERESSE_PRODUTO_CLIENTE)
                .rowMapper(rowMapper())
                .build();
    }

    private RowMapper<InteresseProdutoCliente> rowMapper() {
        return new RowMapper<InteresseProdutoCliente>() {
            @Override
            public InteresseProdutoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                final var cliente = ClienteMapper.map(rs);
                final var produto = ProdutoMapper.map(rs);
                return InteresseProdutoClienteMapper.map(produto, cliente);
            }
        };
    }

}
