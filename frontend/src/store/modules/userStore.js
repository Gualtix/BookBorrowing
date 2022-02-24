import axios from "axios";
const URL = "http://localhost:8080/users";

const state = {
  users: [],
};

const getters = {
  users: (state) => state.users,
};
const mutations = {
  SET_USERS(state, data) {
    state.users = data;
  },
  POST_USER(state, user) {
    state.users.push(user);
  },
};
const actions = {
  async loadUsers({ commit }) {
    await axios
      .get(`${URL}`)
      .then((res) => {
        commit("SET_USERS", res.data);
      })
      .catch((err) => console.error(err));
  },

  async createUser({ commit }, user) {
    await axios
      .post(`${URL}`, user)
      .then((res) => {
        console.log(res.data);
        commit("POST_USER", res.data);
      })
      .catch((err) => console.error(err));
  },
};

export default {
  state,
  getters,
  actions,
  mutations,
};