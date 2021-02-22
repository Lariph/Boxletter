<template>
  <v-container fluid>
    <v-data-iterator :items="list_movie" :items-per-page.sync="moviesPerPage">
      <template v-slot:default>
        <v-row>
          <v-col
            v-for="movie in list_movie"
            :key="movie.name"
            cols="12"
            sm="6"
            md="4"
            lg="3"
          >
            <v-card>
              <v-card-title class="subheading font-weight-bold">
                {{ movie.name }}

                <v-spacer></v-spacer>
                      <v-menu bottom left>
                        <template v-slot:activator="{ on, attrs }">
                          <v-btn
                            icon
                            v-bind="attrs"
                            v-on="on"
                          >
                          <v-icon>mdi-dots-vertical</v-icon>
                          </v-btn>
                        </template>
                        <v-list>
                          <v-list-item @click="deletar(movie.id)" href='http://localhost:8080/'>
                            <v-list-item-title>Remover</v-list-item-title>
                          </v-list-item>
                        </v-list>
                      </v-menu>
              </v-card-title>

              <v-divider></v-divider>

              <v-list dense>
                <v-list-item>
                  <v-list-item-content>Classificação:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ movie.rate }}
                  </v-list-item-content>
                </v-list-item>

                <v-list-item>
                  <v-list-item-content>Review:</v-list-item-content>
                  <v-list-item-content class="align-end">
                    {{ movie.review }}
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-card>
          </v-col>
        </v-row>
      </template>

    </v-data-iterator>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      moviesPerPage: 4,
      list_movie: [],
      items: [
        { title: 'Click Me' },
        { title: 'Click Me' },
        { title: 'Click Me' },
        { title: 'Click Me 2' },
      ],
    }),
    created() {
        fetch("http://localhost:8085/listar")
            .then(response => {
                return response.json();
            })
            .then(data => {
                this.list_movie = data;
                console.log("aqui")
                console.log(data);
            })    
    },
    methods: {
    deletar(id) {
      this.axios.get('http://localhost:8085/remover/' + id)
        .then((result)=> {
            console.log(result);
        })
        console.log(this.id);
    }
  }
  }
</script>