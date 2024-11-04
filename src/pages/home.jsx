import React, { useState } from 'react'
import './home.css'

function home() {
    const [encrypt, setEncrypt] = useState("")
    const [decrypt, setDecrypt] = useState("")

  return (
    <>
        <section className='encrypt'>
            <h1>Encryption</h1>
            <div className={encrypt==""?"hidden":"result"}>
                <h3>Result:</h3>
                <textarea type="text" readOnly/>
            </div>
             <form action="">
                <input type="text" />
                <input type="text" />
                <input type="submit" />
             </form>
        </section>
        <section className='decrypt'>
            <h1>Decryption</h1>
            {console.log(encrypt)}
            <div className={(decrypt==="")?"hidden":"result"}>
                <h3>Result:</h3>
                <textarea type="text" readOnly/>
            </div>
        </section>
    </>
  )
}

export default home