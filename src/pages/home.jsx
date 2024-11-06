import React, { useState } from 'react'
import './home.css'
import Form from '../componets/form'
function home() {
    const [encrypt, setEncrypt] = useState("")
    const [decrypt, setDecrypt] = useState("")

  return (
    <>
        <section className='encrypt'>
            <h1>Encryption</h1>
            <div className={encrypt==""?"hidden":"result"}>
                <h3>Result:</h3>
                <textarea type="text" readOnly value={encrypt}/>
            </div>
             <Form typeOfAction={"Encode"} setResult={setEncrypt}></Form>
        </section>
        <section className='decrypt'>
            <h1>Decryption</h1>
            {console.log(encrypt)}
            <div className={(decrypt==="")?"hidden":"result"}>
                <h3>Result:</h3>
                <textarea type="text" readOnly/>
            </div>
            <Form typeOfAction={"Decode"} setResult={setDecrypt}></Form>
        </section>
    </>
  )
}

export default home