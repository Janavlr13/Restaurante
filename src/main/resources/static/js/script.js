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
    const nomes = document.querySelectorAll('.coluna-numeroMesa');
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
    const nomes = document.querySelectorAll('.coluna-nome');
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

function toggleTabela(){
    let tabela = document.getElementById("tabelaClientes");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
    } else {
        tabela.style.display = "none";
    }
}

