package br.com.wferreiracosta.enviopromocoesclientes.utils.mappers;

import br.com.wferreiracosta.enviopromocoesclientes.domains.Produto;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProdutoMapper {

    public static Produto map(ResultSet rs) throws SQLException {
        return Produto.builder()
                .id(rs.getInt("produto_id"))
                .nome(rs.getString("produto_nome"))
                .descricao(rs.getString("produto_descricao"))
                .preco(rs.getDouble("produto_preco"))
                .build();
    }

}
