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
      list_movie: []
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
    }
  }
</script>