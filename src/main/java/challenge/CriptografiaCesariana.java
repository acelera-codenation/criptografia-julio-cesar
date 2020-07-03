package challenge;

/**
 * The type Criptografia cesariana.
 */
public class CriptografiaCesariana implements Criptografia {

    /**
     * The constant MSG_NAO_INFORMADA.
     */
    private static final String MSG_NAO_INFORMADA = "A mensagem não foi informada.";
    private final int TAMANHO_ALFABETO = 26;
    private final char LETRA_A = 'a';
    private final int CHAVE = 3;

    /**
     * Criptografar string.
     *
     * @param texto the texto
     * @param chave the chave
     * @return the string
     */
    public String criptografar(String texto, int chave) {
        validarMensagem(texto);
        StringBuilder textoCifrado = new StringBuilder();
        char[] msg = texto.toLowerCase().toCharArray();
        for (char character : msg) {
            if (Character.isDigit(character) || Character.isSpaceChar(character)) textoCifrado.append(character);
            else {
                int posicaoInicial = character - LETRA_A;
                int novaPosicao = (posicaoInicial + chave) % TAMANHO_ALFABETO;
                char novaLetra = (char) (LETRA_A + novaPosicao);
                textoCifrado.append(novaLetra);
            }
        }
        return textoCifrado.toString();
    }

    /**
     * Validar se o texto é nulo ou vazio.
     * @param texto
     */
    private void validarMensagem(String texto) {
        if (texto == null) throw new NullPointerException(MSG_NAO_INFORMADA);
        if (texto.isEmpty()) throw new IllegalArgumentException(MSG_NAO_INFORMADA);
    }

    /**
     * Criptografar mensagem
     *
     * @param texto
     * @return
     */
    @Override
    public String criptografar(String texto) {
        return criptografar(texto, CHAVE);
    }

    /**
     * Descriptografar mensagem
     *
     * @param texto
     * @return
     */
    @Override
    public String descriptografar(String texto) {
        return criptografar(texto, TAMANHO_ALFABETO - (CHAVE % TAMANHO_ALFABETO));
    }
}
