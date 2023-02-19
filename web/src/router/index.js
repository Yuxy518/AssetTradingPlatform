import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView'
import LoginView from '@/views/LoginView'
import RegisterView from '@/views/RegisterView'
import FeedbackView from '@/views/FeedbackView'
import Refinancing_ContractView from '@/views/Refinancing/ContractView'
import Refinancing_InfoView from '@/views/Refinancing/InfoView'
import Refinancing_RecordsView from '@/views/Refinancing/RecordsView'
import Deposit_ContractView from '@/views/Deposit/ContractView'
import Deposit_InfoView from '@/views/Deposit/InfoView'
import Deposit_PayView from '@/views/Deposit/PayView'
import Deposit_RecordsView from '@/views/Deposit/RecordsView'
import Contract_ContractView from '@/views/Contract/ContractView'
import Contract_InfoView from '@/views/Contract/InfoView'
import Contract_RecordsView from '@/views/Contract/RecordsView'
import Mortgage_InfoView from '@/views/Mortgage/InfoView'
import Mortgage_ContractView from '@/views/Mortgage/ContractView'
import Mortgage_RecordsView from '@/views/Mortgage/RecordsView'
import Default_ComplaintView from '@/views/Default/ComplaintView'
import Default_RecordsView from '@/views/Default/RecordsView'
import TestView from '@/views/TestView.vue'

import store from '@/store'

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView,
    meta: {
      RequireLogin: false,
    }
  },
  {
    path: '/account/login/',
    name: 'LoginView',
    component: LoginView,
    meta: {
      RequireLogin: false,
    }
  },
  {
    path: '/account/register/',
    name: 'RegisterView',
    component: RegisterView,
    meta: {
      RequireLogin: false,
    }
  },
  {
    path: '/feedback/',
    name: 'FeedbackView',
    component: FeedbackView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/refinancing/contract/',
    name: 'Refinancing_ContractView',
    component: Refinancing_ContractView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/refinancing/info/',
    name: 'Refinancing_InfoView',
    component: Refinancing_InfoView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/refinancing/records/',
    name: 'Refinancing_RecordsView',
    component: Refinancing_RecordsView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/deposit/contract/',
    name: 'Deposit_ContractView',
    component: Deposit_ContractView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/deposit/info/',
    name: 'Deposit_InfoView',
    component: Deposit_InfoView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/deposit/pay/',
    name: 'Deposit_PayView',
    component: Deposit_PayView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/deposit/records/',
    name: 'Deposit_RecordsView',
    component: Deposit_RecordsView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/contract/contract/',
    name: 'Contract_ContractView',
    component: Contract_ContractView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/contract/info/',
    name: 'Contract_InfoView',
    component: Contract_InfoView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/contract/records/',
    name: 'Contract_recordsView',
    component: Contract_RecordsView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/mortgage/info/',
    name: 'Mortgage_InfoView',
    component: Mortgage_InfoView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/mortgage/contract/',
    name: 'Mortgage_ContractView',
    component: Mortgage_ContractView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/mortgage/records/',
    name: 'Mortgage_RecordsView',
    component: Mortgage_RecordsView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/default/complaint/',
    name: 'Default_ComplaintView',
    component: Default_ComplaintView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/default/records/',
    name: 'Default_RecordsView',
    component: Default_RecordsView,
    meta: {
      RequireLogin: true,
    }
  },
  {
    path: '/test/',
    name: 'TestView',
    component: TestView,
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem("jwt_token");

  if (store.state.user.is_login) next();
  else if (token) {
    store.commit("updateToken", token);
    store.dispatch("getInfo", {
      success() {

      }
    });
    next();
  }
  else if (!to.meta.RequireLogin) {
    next();
  }
  else {
    alert("请先登录~~");
    next({ name: "LoginView" });
  }
});