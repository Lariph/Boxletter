<template>
<v-container fluid>
    <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="form.name"
      :rules="nameRules"
      label="Nome do filme"
      required
    ></v-text-field>

    <v-text-field
      v-model="form.review"
      :rules="reviewRules"
      label="Review"
      required
    ></v-text-field>

    <v-text-field
      v-model="form.rate"
      :rules="rateRules"
      label="Classificação"
      required
    ></v-text-field>

    <v-btn
      :disabled="!valid"
      color="success"
      class="mr-4"
      @click="checkForm"
    >
      Inserir
    </v-btn>

  </v-form>
  </v-container>
</template>

<script>
export default {
    data: () => ({
      valid: true,
      nameRules: [
        v => !!v || 'Nome é obrigatório',
      ],
      reviewRules: [
        v => !!v || 'Review é obrigatório',
      ],
      rateRules: [
        v => !!v || 'Classificação é obrigatório',
        v => Number.isInteger(Number(v)) || 'Precisa ser um número inteiro',
        v => (v <= 5) || 'Precisa ser menor que 5'
      ],
      form: {
          name: '',
          review: '',
          rate: null
      }
    }),
    methods: {
      validate () {
        this.$refs.form.validate()
      },
      checkForm(e) {
      if(this.form.name && this.form.review && this.form.rate) {
        this.axios.post('http://localhost:8085/inserir', this.form)
        .then((result)=> {
            console.log(result);
        })
        e.preventDefault();
      }
      if(!this.form.name && !this.form.review && !this.form.rate) {
        window.alert("Campos são obrigatórios");
        e.preventDefault();
      }
    },
    },
    }
</script>