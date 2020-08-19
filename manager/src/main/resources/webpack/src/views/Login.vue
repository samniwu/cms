<style scoped>
  .login-container {
    height: 100%;
    width: 100%;
    display: flex;
    background-color: aqua;
  }
  .login-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 12% auto;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  label.el-checkbox.rememberme {
    margin: 0px 0px 15px;
    text-align: left;
  }
  .title {
    text-align: center;
  }
  .register {
    float: right;
  }
</style>

<template>
  <div class="login-container">
    <el-form :model="loginForm" :rules="loginRule" status-icon ref="loginForm" label-position="left" label-width="0px" class="login-page">
      <h3 class="title">CMS后台管理系统</h3>
      <p v-show="errorStatus">{{message}}</p>
      <el-form-item prop="username">
        <el-input type="text" v-model="loginForm.username" clearable placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" clearable placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox v-model="checked" class="rememberme">记住密码</el-checkbox>
      <el-link href="" @click="register" class="register">注册</el-link>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import $ from '../utils/axios'
  export default {
    data () {
      return {
        logining: false,
        loginForm: {
          username: '',
          password: ''
        },
        loginRule: {
          username: [{required: true, message: 'please enter your account', trigger: 'blur'}],
          password: [{required: true, message: 'enter your password', trigger: 'blur'}]
        },
        checked: false,
        errorStatus: false,
        message: ''
      }
    },
    methods: {
      handleSubmit () {
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.logining = true
            let param = new URLSearchParams()
            param.append('username', this.loginForm.username)
            param.append('password', this.loginForm.password)
            $.post('/user/login', param).then(data => {
              if (data != null) {
                if (data.code === '000000') {
                  this.logining = false
                  this.message = ''
                  this.errorStatus = false
                  sessionStorage.setItem('user', this.loginForm.username)
                  this.$router.push({path: '/home'})
                } else {
                  this.message = '用户名或者密码错误'
                  this.errorStatus = true
                }
              } else {
                this.message = '用户名或者密码错误'
                this.errorStatus = true
              }
            }).catch(function () {
              console.log('error submit!')
            })
          } else {
            console.log('error submit!')
            return false
          }
        })
      },
      register () {

      }
    }
  }
</script>
