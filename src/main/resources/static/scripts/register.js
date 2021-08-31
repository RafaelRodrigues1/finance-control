window.addEventListener('load', () => {
    const registerForm = document.forms[0]
    const form = registerForm
    const name = form.name
    const email = form.email
    const date = form.birthDate
    const phone = form.phone
    const password = form.password
    const confirmPassword = form.confirmPassword

    const sucessMessage = document.getElementById('sucessMessage')
    const errorMessage = document.getElementById('errorMessage')

    const cep = form.cep
    const state = form.state
    const city = form.city
    const neighborhood = form.neighborhood
    const street = form.street
    const number = form.number

    const personFields = [name, email, date, phone, password, confirmPassword]
    const addressFields = [cep, state, city, neighborhood, street, number]

    const registerButton = document.getElementById('registerButton')

    cep.addEventListener('keyup', () => {
        cep.value = cep.value.replace('-', '')
        if(cep.value.length === 8) {
            getAdress()
        }
    })

    confirmPassword.addEventListener('keyup', () => {
        verifyPasswordFields()
    })

    password.addEventListener('keyup', () => {
        verifyPasswordFields()
    })

    registerButton.addEventListener('click', (evt) => {
        evt.preventDefault()
        if(validation()) {
            registerForm.submit()
        }
    })

    //--------Funções--------//

    function verifyPasswordFields(){
        if(password.value === confirmPassword.value){
            sucessMessage.style.display = 'block'
            errorMessage.style.display = 'none'
            return true
        }else {
            sucessMessage.style.display = 'none'
            errorMessage.style.display = 'block'
            return false
        }
    }

    function verifyPasswordLength(){
        return !(password.value.length < 8 || password.value.length > 14)
    }

    function getAdress(){
        fetch(`https://viacep.com.br/ws/${cep.value}/json/`)
        .then(response => response.json())
        .then(object => {
            if(!object.cep){
                throw new Error('Cep inválido')
            }
            getState(object.uf)
            fillFields(object)   
        })
        .catch(err => {
            alert(err.message)
            clearAddressFields()
        })
    }

    function getState(uf){
        fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${uf}`)
            .then(response => response.json())
            .then(object => state.value = object.nome)
    }

    function fillFields(object){
        cep.value = object.cep
        city.value = object.localidade
        neighborhood.value = object.bairro
        street.value = object.logradouro
    }

    function clearAddressFields(){
        addressFields.forEach(field => field.value = '')
    }

    function validation(){
        const fields = [...personFields, ...addressFields]
        let emptyField = false
        fields.forEach((field) => {
            if(field.value.length === 0) {
                emptyField = true
            }
        })
        if(emptyField) {
            alert('Todos os campos são obrigatórios!')
            return false
        }
        if(!verifyPasswordFields()){
            alert('Senhas não coincidem!')
            confirmPassword.focus()
            return false
        }
        if(!verifyPasswordLength()){
            alert('Senha precisa ter de 8 a 14 caracteres!')
            password.focus()
            return false
        }
        return true
    }
})
