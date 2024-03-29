package com.melayer.googlemapdemo

import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.os.Handler
import android.os.Message
import android.util.Log
import java.io.IOException
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var mMap: GoogleMap
    var locationManager:LocationManager ? =null
    var locationListner:LocationListener ? =null
    var lat:Double ? =0.0
    var log:Double ? =0.0
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationManager= getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0L,0F,mLocationListener)
    }

    private val mLocationListener = object : LocationListener {
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
            Toast.makeText(this@MapsActivity,provider.toString(),Toast.LENGTH_LONG).show()
        }

        override fun onProviderDisabled(provider: String?) {
            Toast.makeText(this@MapsActivity,provider.toString(),Toast.LENGTH_LONG).show()

        }

        override fun onLocationChanged(location: Location) {
            val sydney = LatLng(location.latitude, location.longitude)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Pune"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15F), 2000, null);
            getAddressFromLocation(location.latitude, location.longitude,this@MapsActivity)
            Toast.makeText(this@MapsActivity,"Lat : ${location!!.latitude}\n" +
                    "Long : ${location.longitude}",Toast.LENGTH_LONG).show()
        }
    }


    fun getAddressFromLocation(latitude: Double, longitude: Double,
                               context: Context) {
                val geocoder = Geocoder(context, Locale.getDefault())
                var result: String? = null

                    val addressList = geocoder.getFromLocation(
                            latitude, longitude, 1)
                    if (addressList != null && addressList.size > 0) {
                        val address = addressList[0]
                        val sb = StringBuilder()
                        for (i in 0 until address.maxAddressLineIndex) {
                            sb.append(address.getAddressLine(i)).append("\n")
                        }

                        sb.append(address.locality).append("\n")
                        sb.append(address.postalCode).append("\n")
                        sb.append(address.countryName)
                        result = sb.toString()

                        Toast.makeText(this@MapsActivity,address.toString(),Toast.LENGTH_LONG).show()

                    }


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
