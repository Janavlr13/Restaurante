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

function toggleTabela(){
    let tabela = document.getElementById("tabelaClientes");
    if(tabela.style.display === "none"){
        tabela.style.display = "table";
    } else {
        tabela.style.display = "none";
    }
}

