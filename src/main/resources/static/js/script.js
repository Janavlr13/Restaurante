function marcarCliente(){
   /* let nomes = document.querySelectorAll(".coluna-nome")

    nomes.forEach(function (td){
        td.style.backgroundColor="#ffe599";
    })*/

    const nomes = document.querySelectorAll('.coluna-nome');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}
function marcarGerente() {
    const nomes = document.querySelectorAll('.coluna-nome');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}

function marcarFuncionario() {
    const nomes = document.querySelectorAll('.coluna-nome');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}

function marcarMesa() {
    const nomes = document.querySelectorAll('.coluna-numeroMesa');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}

function marcarReserva() {
    const nomes = document.querySelectorAll('.coluna-data');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}

function marcarNotificacao() {
    const nomes = document.querySelectorAll('.coluna-dataHora');
    for(let i = 0; i < nomes.length; i++){
        nomes[i].classList.toggle('destacado');
    }
}

function toggleTabelaClientes(){
    let tabela = document.getElementById("tabelaClientes");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaFuncionarios(){
    let tabela = document.getElementById("tabelaFuncionarios");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaGerentes(){
    let tabela = document.getElementById("tabelaGerentes");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaMesas(){
    let tabela = document.getElementById("tabelaMesas");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaNotificacoes(){
    let tabela = document.getElementById("tabelaNotificacoes");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaReservas(){
    let tabela = document.getElementById("tabelaReservas");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function toggleTabelaUtilizador(){
    let tabela = document.getElementById("tabelaUtilizadores");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
        tabela.style.width = "100%";
    } else {
        tabela.style.display = "none";
    }
}

function mostrarNovoCliente() {
    var inserirNovoCliente = document.getElementById("novoCliente");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovoFuncionario() {
    var inserirNovoCliente = document.getElementById("novoFuncionario");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovoGerente() {
    var inserirNovoCliente = document.getElementById("novoGerente");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovaReserva() {
    var inserirNovoCliente = document.getElementById("novaReserva");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovaMesa() {
    var inserirNovoCliente = document.getElementById("novaMesa");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovaNotificacao() {
    var inserirNovoCliente = document.getElementById("novaNotificacao");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function mostrarNovoUtilizador() {
    var inserirNovoCliente = document.getElementById("novoUtilizador");
    if(inserirNovoCliente.style.display === "none"){
        inserirNovoCliente.style.display = "flex";
    } else {
        inserirNovoCliente.style.display = "none";
    }
}

function gerarTextoNotificacao() {
    const select = document.getElementById('reservaSelect');
    const textarea = document.getElementById('mensagem');

    const opcao = select.options[select.selectedIndex];

    if (opcao.value !== "") {
        const nome = opcao.getAttribute('data-cliente');
        const data = opcao.getAttribute('data-data');
        const hora = opcao.getAttribute('data-hora');
        const id = opcao.value;

        const mensagemFinal = `Olá ${nome}, confirmamos a sua reserva #${id} para o dia ${data} às ${hora}. Esperamos por si!`;

        textarea.value = mensagemFinal;
    }
}