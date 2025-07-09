import { createStore } from 'vuex';

export default createStore({
  state: {
    count: 0,
    cartItems: [], // 注意变量名应为复数形式，表示多个商品
  },
  mutations: {
    increment(state) {
      state.count++;
    },
    addCart(state, items) { // 添加到购物车里
      state.cartItems = items;
    },
    cleanCart(state) {
      state.cartItems = [];
    },
    removeFromCart(state, id) { // 从购物车中移除商品
        state.cartItems = state.cartItems.filter(item => item.id !== id);
      },
  },
  actions: {
    increment({ commit }) {
        commit('increment');
      },
      addCart({ commit }, items) {
        commit('addCart', items);
      },
      removeFromCart({ commit }, id) {
        commit('removeFromCart', id);
      },
      clearCart({ commit }) {
        commit('clearCart');
      },
    },
  getters: {
    doubleCount: state => state.count * 2,
    sanbeiCount: state => state.count * 3,
    sibeiCount: state => state.count * 4,
    wubeiCount: state => state.count * 5,
    liubeiCount: state => state.count * 6,
    qibeiCount: state => state.count * 7,
    babeiCount: state => state.count * 8,
    limitlessCount: state => state.count * 1242324832948,
  },
});