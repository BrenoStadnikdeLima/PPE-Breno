const criar = () => {
  const cidade = document.querySelector('#cidade').value
  const estadio = document.querySelector('#estadio').value
  const nome = document.querySelector('#nome').value
  axios.post('http://localhost:8080/time/', {
    nome,
    estadio,
    cidade
  })
  .then(function (response) {
    document.location.reload(true);
  })
  .catch(function (error) {
    console.log(error);
  });
}

const RenderizarTimes = async () => {
  const arrayTimes = await axios.get('http://localhost:8080/time/')
    .then(res => res.data)
    .catch(error => console.error(error))
    
  if(arrayTimes != null || arrayTimes.legth != 0){
    arrayTimes.map((time) => {
      document.getElementById('tbody').innerHTML += `  
        <tr class="table-row">
          <td class="table-data" id={${time.id}}>${time.id}</td>
          <td class="table-data">${time.cidade}</td>
          <td class="table-data">${time.estadio}</td>
          <td class="table-data">${time.nome}</td>
          <td>
            <button onclick="MostrarFormularioEditar(${time.id})">editar</button>
            <button onclick="deletar(${time.id})">deletar</button>
          <td>
        </tr>
      ` 
    })
  }
}

const editar = () => {
  const cidade = document.querySelector('#cidade').value
  const estadio = document.querySelector('#estadio').value
  const nome = document.querySelector('#nome').value

  const id = localStorage.getItem("itemAtual")
  try {
    axios.put(`http://localhost:8080/time/${id}`, {
      nome,
      estadio,
      cidade
    })
    document.location.reload(true);
  } 
  catch (err) {
    if (err.response.status === 404) {
        console.log('Resource could not be found!');
    } else {
        console.log(err.message);
    }
  }
}

const deletar = (id) => {
  axios.delete(`http://localhost:8080/time/${id}`)
  document.location.reload(true);
  alert("Usuário de id: " + id + " foi deletado com sucesso!")
}

const MostrarFormularioEditar = async (id) => {
  document.querySelector('#formulario').style = "display: block"
  document.querySelector('#button-criar').style = "display:none"
  document.querySelector('#button-editar').style = "display: block"
  localStorage.setItem("itemAtual", id)
}

const MostrarFormularioCriar = () => {
  document.querySelector('#formulario').style = "display: block"
  document.querySelector('#button-criar').style = "display: block"
  document.querySelector('#button-editar').style = "display:none"
}


RenderizarTimes()
