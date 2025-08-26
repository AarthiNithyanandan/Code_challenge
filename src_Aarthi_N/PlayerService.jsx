import axios from "axios";

const BASE_URL = "http://localhost:8080/api/players";

export const PlayerService = {
  
  getAll() {
    return axios.get(`${BASE_URL}/getall`);
  },

  get(id) {
    return axios.get(`${BASE_URL}/getplayerbyId/${id}`);
  },

  create(player) {
    return axios.post(`${BASE_URL}/addplayer`, player);
  },

  update(id, player) {
    return axios.put(`${BASE_URL}/update/${id}`, player);
  },
   searchByTeam(teamName) {
    return axios.get(`${BASE_URL}/search/${teamName}`);
  }


};
